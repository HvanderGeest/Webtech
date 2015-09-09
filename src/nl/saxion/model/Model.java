package nl.saxion.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model {
	private HashMap<String, User> users = new HashMap<>();

	public User getUser(String userName) {
		return users.get(userName);
	}

	public void addUser(User u) {
		users.put(u.getUsername(), u);
	}

	public boolean userNameExists(String userName) {
		return users.containsKey(userName);
	}

	

	public List<Kamer> searchRooms(int minSurface, int maxPrice, String country) {
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
		((Verhuurder) verhuurder).addRoom(new Kamer(surface, price, place));
	}

	public List<User> getUsers() {
		List<User> userList = new ArrayList<>(users.values());
		return userList;
	}

	public User getLandlord(Kamer kamer) {
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
