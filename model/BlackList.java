package com.mfi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BlackList {
	
	@Id
	private Integer blackListId;
	private String name;
	private String nrc;
	private String address;
	private String fatherName;
	private String createdUser;
	private Date createdDate;
	private String updateUser;
	private Date updateDate;
	
	
	public BlackList() {
		super();
	}


	


	
	
	

}
