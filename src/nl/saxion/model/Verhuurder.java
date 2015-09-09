package nl.saxion.model;

import java.util.ArrayList;
import java.util.List;

public class Verhuurder extends User {
	private List<Kamer> kamers = new ArrayList<>();
	

	public Verhuurder(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the kamers
	 */
	public List<Kamer> getKamers() {
		return kamers;
	}


	/**
	 * @param kamers the kamers to set
	 */
	public void addRoom(Kamer kamer) {
		kamers.add(kamer);
	}
	
	public boolean hasRoom(Kamer kamer){
		return kamers.contains(kamer);
	}

}
