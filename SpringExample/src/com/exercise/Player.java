package com.exercise;

public class Player {

	private String gamename;
	private User gameuser;

	
	public Player() {
		super();
	}

	

	public void setGamename(String gamename) {
		this.gamename = gamename;
	}



	public void setGameuser(User gameuser) {
		this.gameuser = gameuser;
	}



	public String getGamename() {
		return gamename;
	}

	public User getGameuser() {
		return gameuser;
	}

	public void play() {
	System.out.println(gameuser+" is playing a "+gamename);
	}
}
