package com.exercise;

public class User {

	private int id;
	private String userName;
	
	
	

	

	public User() {
		super();
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String toString(){
		return id+""+userName;
		}
}
