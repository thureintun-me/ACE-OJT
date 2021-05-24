package com.mfi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	private String transactionId;
	private String accountNumber;
	private Date date;
	private Double amount;
	private String transactionType;
	private String accountName;
	private String narration;
	private String createdUser;
	private Date createdDate;
	private String updateUser;
	private Date updateDate;
	
	public Transaction() {
		super();
	}

	

}
