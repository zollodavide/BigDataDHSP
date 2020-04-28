package models;

public class StockOutput implements Comparable<StockOutput>{
	

	private double variazione;
	private double meanVolume;
	private double minPrice;
	private double maxPrice;

	
	public StockOutput(double variazione, double meanVolume, double minPrice, double maxPrice) {
		this.variazione = variazione;
		this.meanVolume = meanVolume;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	
	
	public double getVariazione() {
		return variazione;
	}
	
	
	public void setVariazione(double variazione) {
		this.variazione = variazione;
	}
	
	
	public double getMeanVolume() {
		return meanVolume;
	}
	
	
	public void setMeanVolume(double meanVolume) {
		this.meanVolume = meanVolume;
	}
	
	
	public double getMinPrice() {
		return minPrice;
	}
	
	
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	
	
	public double getMaxPrice() {
		return maxPrice;
	}
	
	
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(maxPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(meanVolume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(minPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(variazione);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		StockOutput other = (StockOutput) obj;
		if (Double.doubleToLongBits(maxPrice) != Double.doubleToLongBits(other.maxPrice))
			return false;
		if (Double.doubleToLongBits(meanVolume) != Double.doubleToLongBits(other.meanVolume))
			return false;
		if (Double.doubleToLongBits(minPrice) != Double.doubleToLongBits(other.minPrice))
			return false;
		if (Double.doubleToLongBits(variazione) != Double.doubleToLongBits(other.variazione))
			return false;
		return true;
	}


	@Override
	public int compareTo(StockOutput arg0) {
		if(getVariazione() > arg0.getVariazione())
			return 1;
		else if(getVariazione() < arg0.getVariazione())
			return -1;
		else
			return 0;
	}
	
	

}
