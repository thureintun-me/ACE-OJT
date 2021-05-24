package com.studentmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.studentmanagement.dto.StudentDTO;
import com.studentmanagement.dto.UserDTO;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	
	public void insertStudent(StudentDTO dto) {
		studentRepository.save(dto);
		
	}
	
	public void updateStudent(StudentDTO dto,String studentId) {
		studentRepository.save(dto);
	}
	
	public void deleteStudent(String  studentId) {
		studentRepository.deleteById(studentId);
		
	}
	
	public List<StudentDTO> getAllStudent(){
		List<StudentDTO> list = (List<StudentDTO>) studentRepository.findAll();
		return list;
	}
	
	public List<StudentDTO> findById(String studentId){
		return studentRepository.selectById(studentId);
	}
	
	public List<StudentDTO> findByName(String studentName) {
		return studentRepository.findByName(studentName);
		
	}
	
	public List<StudentDTO> findByClass(String className){
		return studentRepository.findByClass(className);
	}
}
