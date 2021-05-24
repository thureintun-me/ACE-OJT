package com.mfi.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class COA {

	@Id
	private String CoaId;
	private String bankId;
	private String glType;
	private String accountNumber;
	private Double amount;
	private User createdUser;
	private Date createdDate;
	private User updateUser;
	private Date updateDate;
	public COA() {
		super();
	}
	public COA(String coaId, String bankId, String glType, String accountNumber, Double amount, User createdUser,
			Date createdDate, User updateUser, Date updateDate) {
		super();
		CoaId = coaId;
		this.bankId = bankId;
		this.glType = glType;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
	}
	public String getCoaId() {
		return CoaId;
	}
	public void setCoaId(String coaId) {
		CoaId = coaId;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getGlType() {
		return glType;
	}
	public void setGlType(String glType) {
		this.glType = glType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public User getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public User getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
