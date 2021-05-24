package com.mfi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class COA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CoaId;
	private int bankId;
	private String glType;
	private String accountNumber;
	private Double amount;
	private int createdUser;
	private Date createdDate;
	private String updateUser;
	private Date updateDate;

	public COA() {
		super();
	}

	
}
