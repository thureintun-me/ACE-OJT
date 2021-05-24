package com.mfi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Serial {

	@Id
	private String serialId;
	private String serialAccount;
	private String createdUser;
	private Date createdDate;
	private String updateUser;
	private Date updateDate;
	
	public Serial() {
		super();
	}

	
	
}
