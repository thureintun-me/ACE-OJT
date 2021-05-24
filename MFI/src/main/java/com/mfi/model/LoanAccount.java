package com.mfi.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LoanAccount {

	@Id
	private String loanAccountNumber;
	private Double loanAmount;
	private Boolean accountStatus;
	private Date openingDate;
	private Date closeDate;
	private Timestamp ts;
	private int createdUser;
	private Date createdDate;
	private int updateUser;
	private Date updateDate;
	@OneToOne
	private CurrentAccount currentAccount;
	@OneToOne
	private SavingAccount savingAccount;
	@OneToOne
	private Customer customer;
	@OneToOne
	private LoanInfo loanInfo;
	
	public LoanAccount() {
		super();
	}
	

	public LoanAccount(String loanAccountNumber, Double loanAmount, Boolean accountStatus, Date openingDate,
			Date closeDate, Timestamp ts, int createdUser, Date createdDate, int updateUser, Date updateDate) {
		super();
		this.loanAccountNumber = loanAccountNumber;
		this.loanAmount = loanAmount;
		this.accountStatus = accountStatus;
		this.openingDate = openingDate;
		this.closeDate = closeDate;
		this.ts = ts;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
	}


	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(String loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
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
	

	
}
