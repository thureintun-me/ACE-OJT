package com.mfi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mfi.model.Permission;
import com.mfi.model.Role;

public interface PermissionRepository extends JpaRepository<Permission,String>{
	@Query("select p from Permission p where p.id=?1") 
	  Permission findbyId(int id);
}
