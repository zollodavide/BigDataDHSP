import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StatisticheReducer extends Reducer<Text, StockCustomValue, Text, Text>{
	

	
	@Override
	protected void reduce(Text key, Iterable<StockCustomValue> value,
			Reducer<Text, StockCustomValue, Text, Text>.Context context) throws IOException, InterruptedException {
		
		double lastPrice2008 = 0;
		double lastPrice2018 = 0;
		String[] maxData2008 = {"0" , "0", "0"};
		String[] maxData2018 = {"0" , "0", "0"};
		
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;
		int count = 0;
		int sum = 0;
		
		for (StockCustomValue stock : value) {
			
			System.out.println("DATA: "+stock.getData().toString()+"\n");
			
			if(stock.getAnno() == "2008") {
				if(StatisticheUtility.dataMaggiore(stock.getData(), maxData2008)) {
					maxData2008 = stock.getData();
					lastPrice2008 = stock.getPrezzoChiusura();
				}
			}
			
			if(stock.getAnno() == "2018") {
				if(StatisticheUtility.dataMaggiore(stock.getData(), maxData2018)) {
					maxData2018 = stock.getData();
					lastPrice2018 = stock.getPrezzoChiusura();
				}				
				else 
					lastPrice2018 = 10;
			}
			
			min = Math.min(min, stock.getMinPrezzo());
			max = Math.max(max, stock.getMaxPrezzo());
			sum += stock.getVolume();
			count++;
		}
		
		double variazionePercentuale = (lastPrice2008 - lastPrice2018) / lastPrice2018;
		
		double mean = sum/count;
		Text out = new Text("Minimum Price: "+ min + ", Maximum Price: " + max+ ", Mean Volume: "+
				mean+ ", Variazione Percentuale:" + variazionePercentuale);
		
		context.write(key, out);
		
	}
	
}
