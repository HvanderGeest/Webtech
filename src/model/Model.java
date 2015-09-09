package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model {
	private HashMap<String, User> users = new HashMap<>();
	private ArrayList<Kamer> kamers = new ArrayList<>();
	
	
	public User getUser(String userName){
		return users.get(userName);
	}
	
	public void addUser(User u){
		users.put(u.getUsername(), u);
	}
	
	public boolean userNameExists(String userName){
		return users.containsKey(userName);
	}
	
	public List<Kamer> getRoomsFromLandLord(User u){
		List<Kamer> list = new ArrayList<>();
		for(Kamer k : kamers){
			if(k.getLandLord().getUsername().equals(u.getUsername())){
				list.add(k);
			}
		}
		return list;
	}
	
	public List<Kamer> searchRooms(int minSurface, int maxPrice, String country){
		List<Kamer> rooms = new ArrayList<>();
		for(Kamer k : kamers){
			if(k.getSurfaceInMeter() >= minSurface && k.getPriceInEuro() <= maxPrice && k.getPlace().equalsIgnoreCase(country)){
				rooms.add(k);
			}
		}
		return rooms;
	}
	
	public void addRoom(int surface, int price, String place, User verhuurder){
		kamers.add(new Kamer(surface, price, place, verhuurder));
	}
	
	public List<User> getUsers(){
		List<User> userList = new ArrayList<>(users.values());
		return userList;
	}

}
