package nl.saxion.model;

public class Kamer {
	private int surfaceInMeter;
	private int priceInEuro;
	private String place;
	private User landLord;
	
	public Kamer(int surfaceInMeter, int priceInEuro, String place, User landLord) {
		this.surfaceInMeter = surfaceInMeter;
		this.priceInEuro = priceInEuro;
		this.place = place;
		this.landLord = landLord;
	}

	public User getLandLord() {
		return landLord;
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
