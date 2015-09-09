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

}
