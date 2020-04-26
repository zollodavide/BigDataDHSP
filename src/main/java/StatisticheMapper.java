import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StatisticheMapper extends Mapper<Object, Text, Text, StockCustomValue> {
	
	private Text ticker = new Text(); 
	private StockCustomValue custom = new StockCustomValue();
	
	
	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, Text, StockCustomValue>.Context context)
			throws IOException, InterruptedException {
		
		String[] parts = value.toString().split(",");
		ticker.set(parts[HistoricalStockPricesConstants.TICKER]);
		
		try {
			custom.setMaxPrezzo(Double.parseDouble(parts[HistoricalStockPricesConstants.HIGHTHE]));	
		} catch(Exception e) {
			custom.setMaxPrezzo(0);
		}
		
		try {
			custom.setMinPrezzo(Double.parseDouble(parts[HistoricalStockPricesConstants.LOWTHE]));	
		} catch(Exception e) {
			custom.setMinPrezzo(0);
		}
		
		try {
			custom.setVolume(Integer.parseInt(parts[HistoricalStockPricesConstants.VOLUME]));	
		} catch(Exception e) {
			//QUESTA SOLUZIONE NON VA BENE VISTO CHE ANCHE MESSO A 0 
			//INFLUENZA NELLA MEDIA. LA SOLUZIONE È SALTARE L'INTERO INPUT
			custom.setVolume(0); 
		}		
		
		try {
			String[] data = parts[HistoricalStockPricesConstants.DATE].split("-");
			if(Integer.parseInt(data[0])>2008) {
				context.write(ticker, custom);
			}
		} catch(Exception e) {
			//ANCHE IN QUESTO CASO LA SOLUZIONE È SALTARE L'INPUT.
		}
	}

}
