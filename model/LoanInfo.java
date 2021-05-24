package com.mfi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoanInfo {
	
	@Id
	private String LoanInfoId;
	private Double loanAmount;
	private Date registerDate;
	private Integer period;
	private double interestRate;
	private Integer numberOfPayment;
	private String description;
	private Integer creditScore;
	private String  status;
	private String createdUser;
	private Date createdDate;
	private String updateUser;
	private Date updateDate;
	
	public LoanInfo() {
		super();
	}

	

	
	

}
