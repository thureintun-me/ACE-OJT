package com.mfi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private String customerCode;
	private String name;
	private String nrc;
	private String phone;
	private Integer dob;
	private String gender;
	private String address;
	private String currentJob;
	private String positon;
	private String companyName;
	private double monthlyIncome;
	private boolean delStatus;
	private String createdUser;
	private Date createdDate;
	private String updateUser;
	private Date updateDate;
	
	
	public Customer() {
		super();
	}


	

}
