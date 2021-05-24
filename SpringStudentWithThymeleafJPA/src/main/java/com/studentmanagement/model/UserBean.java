package com.studentmanagement.model;

import javax.validation.constraints.NotEmpty;

public class UserBean {

	@NotEmpty(message = "User Id cannot be empty!!!")
	private String userId;
	@NotEmpty(message = "User Name cannot be empty!!!")
	private String userName;
	@NotEmpty(message = "password cannot be empty!!!")
	private String password;
	@NotEmpty(message = "confirm Password cannot be empty!!!")
	private String confirmPass;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPass() {
		return confirmPass;
	}
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
	
	
	
	
}
