package nl.saxion.model;

public abstract class User {
	private String username;
	private String password;

	
	public User(String username, String password){
		assert username != null: "username is een nullpointer";
		assert password != null: "password is een nullpointer";
		assert !username.isEmpty(): "username is leeg";
		assert !password.isEmpty() : "password is leeg ";
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
