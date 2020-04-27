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

	public void write(DataOutput out) throws IOException {
		out.writeDouble(minPrezzo);
		out.writeDouble(maxPrezzo);
		out.writeInt(volume);
		out.writeDouble(prezzoChiusura);
		out.writeInt(anno);
		out.writeInt(mese);
		out.writeInt(giorno);
	}

	public void readFields(DataInput in) throws IOException {
		minPrezzo = in.readDouble();
		maxPrezzo = in.readDouble();
		volume = in.readInt();
		prezzoChiusura = in.readDouble();
		anno = in.readInt();
		mese = in.readInt();
		giorno = in.readInt();
		
	}

	
	

	
}
