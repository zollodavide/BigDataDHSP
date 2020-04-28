package models;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class StockPricesCustomValue implements Writable{
	
	
	//RICONTROLLARE DATA COME ARRAY DI STRINGHE
	
	//VARIAZIONE: 
	// IN | FIN -> VARIAZIONE
	// 10 | 20 -> +100%   
	// 20 | 10 -> -50%
	
	private double minPrezzo;
	private double maxPrezzo;
	private int volume;
	private double prezzoChiusura;
	private int anno;
	private int mese;
	private int giorno;

	public StockPricesCustomValue(double minPrezzo, double maxPrezzo, int volume, double prezzoChiusura, int  anno, int mese, int giorno) {
		super();
		this.minPrezzo = minPrezzo;
		this.maxPrezzo = maxPrezzo;
		this.volume = volume;
		this.anno = anno;
		this.mese = mese;
		this.giorno = giorno;
		this.prezzoChiusura = prezzoChiusura;
	}

	
	public StockPricesCustomValue() {
		super();
	}
	
	public void setAnno(int anno) {
		this.anno = anno;
	}

	public void setMese(int mese) {
		this.mese = mese;
	}

	public void setGiorno(int giorno) {
		this.giorno = giorno;
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

	public double getPrezzoChiusura() {
		return prezzoChiusura;
	}
	
	public void setPrezzoChiusura(double prezzoChiusura) {
		this.prezzoChiusura = prezzoChiusura;
	}

	
	public int getAnno() {
		return anno;
	}

	public int getMese() {
		return mese;
	}

	public int getGiorno() {
		return giorno;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeDouble(minPrezzo);
		out.writeDouble(maxPrezzo);
		out.writeInt(volume);
		out.writeDouble(prezzoChiusura);
		out.writeInt(anno);
		out.writeInt(mese);
		out.writeInt(giorno);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		minPrezzo = in.readDouble();
		maxPrezzo = in.readDouble();
		volume = in.readInt();
		prezzoChiusura = in.readDouble();
		anno = in.readInt();
		mese = in.readInt();
		giorno = in.readInt();
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anno;
		result = prime * result + giorno;
		long temp;
		temp = Double.doubleToLongBits(maxPrezzo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + mese;
		temp = Double.doubleToLongBits(minPrezzo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prezzoChiusura);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + volume;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockPricesCustomValue other = (StockPricesCustomValue) obj;
		if (anno != other.anno)
			return false;
		if (giorno != other.giorno)
			return false;
		if (Double.doubleToLongBits(maxPrezzo) != Double.doubleToLongBits(other.maxPrezzo))
			return false;
		if (mese != other.mese)
			return false;
		if (Double.doubleToLongBits(minPrezzo) != Double.doubleToLongBits(other.minPrezzo))
			return false;
		if (Double.doubleToLongBits(prezzoChiusura) != Double.doubleToLongBits(other.prezzoChiusura))
			return false;
		if (volume != other.volume)
			return false;
		return true;
	}

	

	




	
	

	
}
