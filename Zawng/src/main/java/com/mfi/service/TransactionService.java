package com.mfi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfi.model.Transaction;
import com.mfi.model.User;
import com.mfi.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository repo;
	public void deposit(Transaction transaction) {
		repo.save(transaction);
	}
	public void bankTran(Transaction transaction) {
		repo.save(transaction);
	}
	public void disbursement(Transaction transaction) {
		repo.save(transaction);
	}
	public void repayment(Transaction transaction) {
		repo.save(transaction);
	}
}
