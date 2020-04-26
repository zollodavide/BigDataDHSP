import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class StockCustomValue implements Writable{
	
	
	//VARIAZIONE: 
	// IN | FIN -> VARIAZIONE
	// 10 | 20 -> +100%   
	// 20 | 10 -> -50%
	
	
//	private double variazione; //VARIAZIONE: 10 | 20 = +100%   
	private double minPrezzo;
	private double maxPrezzo;
	private int volume;
	
	

	public StockCustomValue(double minPrezzo, double maxPrezzo, int volume) {
		super();
		this.minPrezzo = minPrezzo;
		this.maxPrezzo = maxPrezzo;
		this.volume = volume;
	}
	
	public StockCustomValue() {
		super();
	}

	public double getMinPrezzo() {
		return minPrezzo;
	}

	public void setMinPrezzo(double minPrezzo) {
		this.minPrezzo = minPrezzo;
	}

	public double getMaxPrezzo() {
		return maxPrezzo;
	}

	public void setMaxPrezzo(double maxPrezzo) {
		this.maxPrezzo = maxPrezzo;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	
	
	public void write(DataOutput out) throws IOException {
//		out.writeDouble(variazione);
		out.writeDouble(minPrezzo);
		out.writeDouble(maxPrezzo);
		out.writeInt(volume);
		
	}

	public void readFields(DataInput in) throws IOException {
//		variazione = in.readDouble();
		minPrezzo = in.readDouble();
		maxPrezzo = in.readDouble();
		volume = in.readInt();
	}
	
	
	

	
}
