package models;

public class StockVariationPair {
	
	private double variazione;
	private StockPricesCustomValue stock;
	
	public StockVariationPair() {
		
	}

	public StockVariationPair(double variazione, StockPricesCustomValue stock) {
		this.variazione = variazione;
		this.stock = stock;
	}

	public double getVariazione() {
		return variazione;
	}

	public void setVariazione(double variazione) {
		this.variazione = variazione;
	}

	public StockPricesCustomValue getStock() {
		return stock;
	}

	public void setStock(StockPricesCustomValue stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		long temp;
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
		StockVariationPair other = (StockVariationPair) obj;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (Double.doubleToLongBits(variazione) != Double.doubleToLongBits(other.variazione))
			return false;
		return true;
	}
	
	
	
	
	

}
