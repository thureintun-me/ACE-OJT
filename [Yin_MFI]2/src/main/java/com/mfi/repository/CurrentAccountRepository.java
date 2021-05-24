package com.mfi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mfi.model.CurrentAccount;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, String> {
	@Query("select c from CurrentAccount c where c.customer.customerCode=?1") 
	CurrentAccount findbyCode(String code);
	
	
	@Query("select c from CurrentAccount c where c.currentAccountNumber=?1") 
	CurrentAccount getAccountNumber(String code);
}
