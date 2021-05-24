package com.mfi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LoanSchedule {
	
	@Id
	private String loanScheduleId;
	private Integer paymentTermNo;
	private Date repaymentDate;
	private Double beginningBalance;
	private Date dueDate;
	private Double totalRepaymentAmount;
	private Double interestRate;
	private Double lateFees;
	private Double endingBalance;
	private Double cumulativeInterest;
	private String status;
	private String createdUser;
	private Date createdDate;
	private String updateUser;
	private Date updateDate;
	@ManyToOne
	@JoinColumn(name="loan_id")
	private LoanInfo loanInfo;
	
	public LoanSchedule() {
		super();
	}
	

}
