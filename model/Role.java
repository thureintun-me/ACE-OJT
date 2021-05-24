package com.mfi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	private String roleId;
	private String createdUser;
	private Date createdDate;
	private String updateUser;
	private Date updateDate;
	
	public Role() {
		super();
	}

	
	

}
