import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class StockCustomValue implements Writable{
	
	
	//RICONTROLLARE DATA COME ARRAY DI STRINGHE
	
	//VARIAZIONE: 
	// IN | FIN -> VARIAZIONE
	// 10 | 20 -> +100%   
	// 20 | 10 -> -50%
	
	
	private double minPrezzo;
	private double maxPrezzo;
	private int volume;
	private double prezzoChiusura;
	private String anno;
	private String mese;
	private String giorno;
//	private String[] data;


	public StockCustomValue(double minPrezzo, double maxPrezzo, int volume, double prezzoChiusura, String anno, String mese, String giorno) {
		super();
		this.minPrezzo = minPrezzo;
		this.maxPrezzo = maxPrezzo;
		this.volume = volume;
		this.anno = anno;
		this.mese = mese;
		this.giorno = giorno;
		this.prezzoChiusura = prezzoChiusura;

	}

	
	public StockCustomValue() {
		super();
	}
	
	public void setAnno(String anno) {
		this.anno = anno;
	}

	public void setMese(String mese) {
		this.mese = mese;
	}

	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}


//	public String[] getData() {
//		return data;
//	}
//	
//	public void setData(String[] data) {
//		this.data = data;
//	}

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
	
	public void setData(String[] data) {
		this.anno = data[0];
		this.mese = data[1];
		this.giorno = data[2];
	}
	
	public String[] getData() {
		String[] data = { this.getAnno(), this.getMese(), this.getGiorno()}; 
		return data;
	}
	
	
	public String getAnno() {
		return anno;
	}

	public String getMese() {
		return mese;
	}

	public String getGiorno() {
		return giorno;
	}

	public void write(DataOutput out) throws IOException {
		out.writeDouble(minPrezzo);
		out.writeDouble(maxPrezzo);
		out.writeInt(volume);
		out.writeDouble(prezzoChiusura);
		out.writeChars(anno);
		out.writeChars(mese);
		out.writeChars(giorno);
	}

	public void readFields(DataInput in) throws IOException {
		minPrezzo = in.readDouble();
		maxPrezzo = in.readDouble();
		volume = in.readInt();
		prezzoChiusura = in.readDouble();
		anno = in.readLine();
		mese = in.readLine();
		giorno = in.readLine();
		
	}

	
	

	
}
