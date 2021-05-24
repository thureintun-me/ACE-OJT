package com.mfi.formmodel;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.mfi.model.Customer;

public class CurrentForm {
	private String currentAccountNumber;
	private Double balance;
	private Boolean accountStatus;
	private Date openingDate;
	private Date closeDate;
	private Timestamp ts;
	private int createdUser;
	private Date createdDate;
	private int updateUser;
	private Date updateDate;
	private String customerId;
	public String getCurrentAccountNumber() {
		return currentAccountNumber;
	}
	public void setCurrentAccountNumber(String currentAccountNumber) {
		this.currentAccountNumber = currentAccountNumber;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Boolean getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(Boolean accountStatus) {
		this.accountStatus = accountStatus;
	}
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	public int getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(int createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public CurrentForm(String currentAccountNumber, Double balance, Boolean accountStatus, Date openingDate,
			Date closeDate, Timestamp ts, int createdUser, Date createdDate, int updateUser, Date updateDate,
			String customerId) {
		super();
		this.currentAccountNumber = currentAccountNumber;
		this.balance = balance;
		this.accountStatus = accountStatus;
		this.openingDate = openingDate;
		this.closeDate = closeDate;
		this.ts = ts;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
		this.customerId = customerId;
	}
	public CurrentForm() {
		super();
	}
	
	
	
}
