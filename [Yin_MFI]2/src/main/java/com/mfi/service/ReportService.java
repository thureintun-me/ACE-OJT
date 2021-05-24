package com.mfi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfi.model.Customer;
import com.mfi.model.Transaction;
import com.mfi.repository.CustomerRepository;
import com.mfi.repository.TransactionRepository;


@Service

public class ReportService {
	@Autowired
	TransactionRepository tranRepo;
	@Autowired
	CustomerRepository cusRepo;
	public List<Transaction> selectAllTransaction(){
		return tranRepo.recordDateAscending();
	}
	public List<Transaction> selectByStartDate(Date start,Date end){
		return tranRepo.recordByStartDate(start,end);
	}
	public List<Customer> findCustomerByTodayDate(Date date){
		return cusRepo.findByTodayDate(date);
	}
}
