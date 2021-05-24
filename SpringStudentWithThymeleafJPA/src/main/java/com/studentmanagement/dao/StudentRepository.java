package com.studentmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.studentmanagement.dto.StudentDTO;
import com.studentmanagement.dto.UserDTO;

public interface StudentRepository extends CrudRepository<StudentDTO, String> {

	@Query("select s from StudentDTO s where s.studentId=?1")
	List<StudentDTO> selectById(String userId);
	@Query("select s from StudentDTO s where s.studentName=?1")
	List<StudentDTO> findByName(String studentName);
	@Query("select s from StudentDTO s where s.className=?1")
	List<StudentDTO> findByClass(String className);
}
