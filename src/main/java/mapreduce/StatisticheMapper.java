package mapreduce;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import constants.HistoricalStockPricesConstants;
import models.StockPricesCustomValue;

public class StatisticheMapper extends Mapper<Object, Text, Text, StockPricesCustomValue> {
	
	private Text ticker = new Text(); 
	private StockPricesCustomValue custom = new StockPricesCustomValue();
	
	
	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, Text, StockPricesCustomValue>.Context context)
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
			custom.setPrezzoChiusura(Double.parseDouble(parts[HistoricalStockPricesConstants.CLOSE]));
		} catch(Exception e) {
			custom.setPrezzoChiusura(0);
		}
		
		try {
			String[] data = parts[HistoricalStockPricesConstants.DATE].split("-");

			if(Integer.parseInt(data[0])>=2008) {
				custom.setAnno(Integer.parseInt(data[0]));
				custom.setMese(Integer.parseInt(data[1]));
				custom.setGiorno(Integer.parseInt(data[2]));
				context.write(ticker, custom);
			}
		} catch(Exception e) {
			//ANCHE IN QUESTO CASO LA SOLUZIONE È SALTARE L'INPUT.
		}
	}

}
