package nl.saxion.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model {
	private HashMap<String, User> users = new HashMap<>();

	public User getUser(String userName) {
		assert userName != null: "userName is een nullpointer";
		assert !userName.isEmpty(): "userName is een lege string";
		return users.get(userName);
	}

	public void addUser(User u) {
		assert u != null : "u is een nullpointer";
		users.put(u.getUsername(), u);
	}

	public boolean userNameExists(String userName) {
		assert userName != null: "userName is een nullpointer";
		assert !userName.isEmpty() : "userName is een lege String";
		return users.containsKey(userName);
	}

	

	public List<Kamer> searchRooms(int minSurface, int maxPrice, String country) {
		assert country != null : "country is een nullpointer";
		assert !country.isEmpty() : "country is een lege String";
		List<Kamer> rooms = new ArrayList<>();
		for (User u : users.values()) {
			if (u instanceof Verhuurder) {
				for (Kamer k : ((Verhuurder) u).getKamers()) {
					if (k.getSurfaceInMeter() >= minSurface && k.getPriceInEuro() <= maxPrice
							&& k.getPlace().equalsIgnoreCase(country)) {
						rooms.add(k);
					}
				}
			}
		}
		return rooms;
	}

	public void addRoom(int surface, int price, String place, User verhuurder) {
		assert place != null: "place is een nullpointer";
		assert !place.isEmpty() : "place is een lege String";
		assert verhuurder != null : "verhuurder is een nullpointer";
		((Verhuurder) verhuurder).addRoom(new Kamer(surface, price, place));
	}

	public List<User> getUsers() {
		List<User> userList = new ArrayList<>(users.values());
		return userList;
	}

	public User getLandlord(Kamer kamer) {
		assert kamer != null : "kamer is een nullpointer";
		for (User u : users.values()) {
			if (u instanceof Verhuurder) {
				if(((Verhuurder) u).hasRoom(kamer)){
					return u;
				}
			}
		}
		return null;
	}

}
