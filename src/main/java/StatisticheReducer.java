import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StatisticheReducer extends Reducer<Text, StockCustomValue, Text, Text>{
	

	
	@Override
	protected void reduce(Text key, Iterable<StockCustomValue> value,
			Reducer<Text, StockCustomValue, Text, Text>.Context context) throws IOException, InterruptedException {
		
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;
		int count = 0;
		int sum = 0;
		
		for (StockCustomValue stock : value) {
			min = Math.min(min, stock.getMinPrezzo());
			max = Math.max(max, stock.getMaxPrezzo());
			sum += stock.getVolume();
			count++;
		}
		
		double mean = sum/count;
		Text out = new Text("Minimum Price: "+ min + ", Maximum Price: " + max+ ", Mean Volume: "+mean);
		
		context.write(key, out);
		
	}
	
}
