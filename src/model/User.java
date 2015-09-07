package model;

public class User {
	private String username;
	private String password;
	private String type;
	public static final String HUURDER_STRING = "huurder";
	public static final String VERHUURDER_STRING = "verhuurder";
	
	public User(String username, String password, String type){
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getType() {
		return type;
	}

}
