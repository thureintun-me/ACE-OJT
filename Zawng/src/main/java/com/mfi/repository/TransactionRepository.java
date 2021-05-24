package com.mfi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mfi.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
	@Query("SELECT t FROM Transaction t ORDER BY t.createdDate DESC")
	List<Transaction> recordDateAscending(); 
	
	@Query("select t from Transaction t where t.createdDate between ?1 and ?2")
	List<Transaction> recordByStartDate(Date start,Date end);
}
