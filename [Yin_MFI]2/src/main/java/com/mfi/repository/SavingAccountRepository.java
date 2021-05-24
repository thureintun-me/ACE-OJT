package com.mfi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mfi.model.LoanInfo;
import com.mfi.model.SavingAccount;

public interface SavingAccountRepository extends JpaRepository<SavingAccount, String> {
	
	@Query("select s from SavingAccount s where s.customer.customerCode=?1") 
	  SavingAccount findbyCode(String code);

}
