package nl.saxion.model;

public class Kamer {
	private int surfaceInMeter;
	private int priceInEuro;
	private String place;
	
	public Kamer(int surfaceInMeter, int priceInEuro, String place) {
		this.surfaceInMeter = surfaceInMeter;
		this.priceInEuro = priceInEuro;
		this.place = place;
		
	}

	

	public int getSurfaceInMeter() {
		return surfaceInMeter;
	}

	public int getPriceInEuro() {
		return priceInEuro;
	}

	public String getPlace() {
		return place;
	}
	

}
