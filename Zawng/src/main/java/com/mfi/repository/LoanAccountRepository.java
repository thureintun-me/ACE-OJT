package com.mfi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mfi.model.LoanAccount;

public interface LoanAccountRepository extends JpaRepository<LoanAccount, String> {
	@Query("select lc from LoanAccount lc where lc.customer.customerCode=?1") 
	public LoanAccount findbyCode(String code);

}
