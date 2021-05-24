package com.mfi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LoanInfo {

	@Id
	private String LoanInfoId;
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	private Double loanAmount;
	private Date registerDate;
	private Integer period;
	private double interestRate;
	private Integer numberOfPayment;
	private String description;
	private Integer creditScore;
	private String status;
	private int createdUser;
	private Date createdDate;
	private int updateUser;
	private Date updateDate;
	
	public LoanInfo() {
		super();
	}

	public LoanInfo(String loanInfoId, Customer customer, Double loanAmount, Date registerDate, Integer period,
			double interestRate, Integer numberOfPayment, String description, Integer creditScore, String status,
			int createdUser, Date createdDate, int updateUser, Date updateDate) {
		super();
		LoanInfoId = loanInfoId;
		this.customer = customer;
		this.loanAmount = loanAmount;
		this.registerDate = registerDate;
		this.period = period;
		this.interestRate = interestRate;
		this.numberOfPayment = numberOfPayment;
		this.description = description;
		this.creditScore = creditScore;
		this.status = status;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
	}

	public String getLoanInfoId() {
		return LoanInfoId;
	}

	public void setLoanInfoId(String loanInfoId) {
		LoanInfoId = loanInfoId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Integer getNumberOfPayment() {
		return numberOfPayment;
	}

	public void setNumberOfPayment(Integer numberOfPayment) {
		this.numberOfPayment = numberOfPayment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
