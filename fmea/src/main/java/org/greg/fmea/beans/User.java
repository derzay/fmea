package org.greg.fmea.beans;

public class User {
	
	private int id;
	private String firstname;
	private String lastname;
	private String sso;
	private String email;
	private String username;
	private String password;
	private boolean isAdmin;
	
	public User(int _id, String _firstname, String _lastname, String _sso, String _email, String _username, String _password, boolean _isAdmin) {
		this.setId(_id);
		this.setFirstname(_firstname);
		this.setLastname(_lastname);
		this.setSso(_sso);
		this.setEmail(_email);
		this.setUsername(_username);
		this.setPassword(_password);
		this.setAdmin(_isAdmin);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSso() {
		return sso;
	}

	public void setSso(String sso) {
		this.sso = sso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public static void main(String[] args) {

	}

}
