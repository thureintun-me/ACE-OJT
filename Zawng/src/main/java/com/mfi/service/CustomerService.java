package com.mfi.service;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfi.formmodel.CustomerForm;
import com.mfi.model.CurrentAccount;
import com.mfi.model.Customer;
import com.mfi.model.LoanAccount;
import com.mfi.model.SavingAccount;
import com.mfi.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository repo;
	
	public void save(Customer customer) {
		
		repo.save(customer);
	}
	
	public List<Customer> selectAll(){
		return repo.findAll();
	}
	public Customer selectOne(String code) {
		return repo.findbyCode(code);
	}
	public void update(Customer customer) {
		repo.save(customer);
	}
	public List<Customer> searchNameOrNrc(String namenrc) {
		return repo.findbyNameOrNrc(namenrc);
	}
	
	
	
}
