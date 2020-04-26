import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Statistiche {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("deprecation")
		Job job = new Job(new Configuration(), "Listeners");
		job.setJarByClass(Statistiche.class);
		
		job.setMapperClass(StatisticheMapper.class);
		job.setReducerClass(StatisticheReducer.class);

		job.setMapOutputValueClass(StockCustomValue.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));    
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.waitForCompletion(true);
	}
}
