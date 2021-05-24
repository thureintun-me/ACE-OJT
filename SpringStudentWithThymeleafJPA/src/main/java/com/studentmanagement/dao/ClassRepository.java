package com.studentmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.dto.ClassDTO;
import com.studentmanagement.dto.UserDTO;

@Repository
public interface ClassRepository extends CrudRepository<ClassDTO, String> {

	@Query("select c from ClassDTO c where c.classId=?1")
	List<ClassDTO> selectById(String classId);
}
