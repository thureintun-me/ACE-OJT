package com.student.service;

import java.util.List;

import com.student.dto.StudentDTO;


public interface StudentService {

	int insertStudent(StudentDTO dto);
	int updateStudent(StudentDTO dto);
	int deleteStudent(StudentDTO dto);
	List<StudentDTO> selectStudent(StudentDTO dto);
}
