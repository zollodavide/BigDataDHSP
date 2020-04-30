package mapreduce;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import models.StockPricesCustomValue;
import models.StockOutput;
import utility.StatisticheUtility;

public class StatisticheReducer extends Reducer<Text, StockPricesCustomValue, Text, Text>{

	private Map<String, StockOutput> countMap = new HashMap<String, StockOutput>();

	
	@Override
	protected void reduce(Text key, Iterable<StockPricesCustomValue> value,
			Reducer<Text, StockPricesCustomValue, Text, Text>.Context context) throws IOException, InterruptedException {
		
		double firstPrice2008 = 0;
		double lastPrice2018 = 0;
		int minMese2008=0, minGiorno2008=0, maxMese2018=0, maxGiorno2018=0;
		
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;
		int count = 0;
		long sum = 0;
		
		for (StockPricesCustomValue stock : value) {
						
			if(stock.getAnno() == 2008) {
				if(StatisticheUtility.dataMinore(stock.getMese(),stock.getGiorno(), minMese2008, minGiorno2008)) {
					minMese2008 = stock.getMese();
					minGiorno2008 = stock.getGiorno();
					firstPrice2008 = stock.getPrezzoChiusura();
				}
			}
			
			if(stock.getAnno() == 2018) {
				if(StatisticheUtility.dataMaggiore(stock.getMese(),stock.getGiorno(), maxMese2018, maxGiorno2018)) {
					maxMese2018 = stock.getMese();
					maxGiorno2018 = stock.getGiorno();
					lastPrice2018 = stock.getPrezzoChiusura();
				}
			}
				
			min = Math.min(min, stock.getMinPrezzo());
			max = Math.max(max, stock.getMaxPrezzo());
			sum += stock.getVolume();
			count++;
		}
		
		double variazionePercentuale = Math.round(((firstPrice2008 - lastPrice2018) / lastPrice2018)*100);
		//QUANDO IL NUMERO È A UNA CIFRA SBAGLIA
		
		double mean = sum/count;
	
		countMap.put(key.toString(), new StockOutput(variazionePercentuale, mean, min, max));

	}
	
	
	@Override
	protected void cleanup(Reducer<Text, StockPricesCustomValue, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		Map<String, StockOutput> sorted = countMap
		        .entrySet()
		        .stream()
		        .sorted(Map.Entry.<String,StockOutput>comparingByValue().reversed())
		        .collect(
		            Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
		                LinkedHashMap::new));
		
		for (String key : sorted.keySet()) {
			Text out = new Text("Minimum Price: "+ sorted.get(key).getMinPrice() + ", Maximum Price: " + 
					sorted.get(key).getMaxPrice() + ", Mean Volume: "+
					sorted.get(key).getMeanVolume()+ ", Variazione Percentuale: " 
					+ sorted.get(key).getVariazione() +"%");
			
			context.write(new Text(key), out);
		}
		
	}
	
	
}
