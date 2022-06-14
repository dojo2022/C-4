package model;

import java.io.Serializable;

public class user implements Serializable{

	private int id;
	private String user;
	private String name;
	private String pw;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	public user(int id, String user, String name, String pw) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.pw = pw;
	}

	public user() {
		this.id = 0;
		this.user = "";
		this.name = "";
		this.pw = "";
	}

}
