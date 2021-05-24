package com.studentmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.studentmanagement.dto.ClassDTO;

@Service
public class ClassService {

	@Autowired
	ClassRepository classRepository;
	
	public void insertClass(ClassDTO dto) {
		classRepository.save(dto);
	}
	
	public List<ClassDTO> getAllClass(){
		return (List<ClassDTO>) classRepository.findAll();
	}
	
	public List<ClassDTO> findById(String classId){
		return classRepository.selectById(classId);
	}
}
