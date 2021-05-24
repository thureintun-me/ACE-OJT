package com.studentmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.studentmanagement.dto.ClassRequestDTO;
import com.studentmanagement.dto.ClassResponseDTO;


@Repository
public class ClassDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public int insertClass(ClassRequestDTO dto) {
		
		
		int result = 0;
		
			String sql = "insert into class (class_id,class_name) values(?,?) ";
			
			result = jdbcTemplate.update(sql,dto.getClassId(),dto.getClassName());
		
		
		return result;
	}
	
	public List<ClassResponseDTO> selectClass(ClassRequestDTO dto){
		List<ClassResponseDTO> clsList = new ArrayList<ClassResponseDTO>();
		
		
		if(!dto.getClassId().equals("")) {
			String sql = "select * from class where class_id=?";
			
			
					clsList=jdbcTemplate.query(sql, (rs, rowNum) -> 
					new ClassResponseDTO(rs.getString("class_id"),rs.getString("class_name")),dto.getClassId());

			
			}else if(!dto.getClassName().equals("")) {
				String sql = "select * from class where class_name=?";
				
				

				clsList=jdbcTemplate.query(sql, (rs, rowNum) -> 
						new ClassResponseDTO(rs.getString("class_id"),rs.getString("class_name")),dto.getClassName());

			}else {
				String sql = "select * from class ";
				
				

				clsList=jdbcTemplate.query(sql, (rs, rowNum) -> 
						new ClassResponseDTO(rs.getString("class_id"),rs.getString("class_name")));

			}
		return clsList;
	}
}
