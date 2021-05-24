package com.studentmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.studentmanagement.dto.StudentRequestDTO;
import com.studentmanagement.dto.StudentResponseDTO;
import com.studentmanagement.dto.UserRequestDTO;
import com.studentmanagement.dto.UserResponseDTO;

@Repository
public class StudentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public int insertStudent(StudentRequestDTO dto) {
		
		int result = 0;
		String sql = "insert into student(student_id,student_name,class_name,status,register_date) values (?,?,?,?,?) ";
		
		result = jdbcTemplate.update(sql,dto.getStudentId(),dto.getStudentName(),dto.getClassName(),dto.getStatus(),dto.getRegisterDate());
		return result;
	}
	
	public int updateStudent(StudentRequestDTO dto) {
		int result = 0;
		String sql = "update student set student_name=?,class_name=?,status=?,register_date=? where student_id=?";
		result = jdbcTemplate.update(sql,dto.getStudentName(),dto.getClassName(),dto.getStatus(),dto.getRegisterDate(),dto.getStudentId());
		

		
		return result;
	}
	
	public int deleteStudent(StudentRequestDTO dto) {
		int result = 0;
		
		String sql = "delete from student where student_id = ?";
		result = jdbcTemplate.update(sql,dto.getStudentId());
		return result;
	}
	
	public List<StudentResponseDTO> selectStudent(StudentRequestDTO dto){
		List<StudentResponseDTO> stuList = new ArrayList<StudentResponseDTO>();
		
		
		if(!dto.getStudentId().equals("")) {
			String sql = "select * from student where student_id=?";
			
			stuList=jdbcTemplate.query(
					sql, (rs, rowNum) -> new StudentResponseDTO(
							rs.getString("student_id"),
							rs.getString("student_name"),
							rs.getString("class_name"),
							rs.getString("register_date"),
							rs.getString("status")
							
							),dto.getStudentId());
			
			}else if(!dto.getStudentName().equals("")) {
				String sql = "select * from student where student_name=?";
				
				
				stuList=jdbcTemplate.query(
						sql, (rs, rowNum) -> new StudentResponseDTO(
								rs.getString("student_id"),
								rs.getString("student_name"),
								rs.getString("class_name"),
								rs.getString("register_date"),
								rs.getString("status")
								
								),dto.getStudentName());
			}else if(!dto.getClassName().equals("")) {
				String sql = "select * from student where class_name=?";
				
				
				stuList=jdbcTemplate.query(
						sql, (rs, rowNum) -> new StudentResponseDTO(
								rs.getString("student_id"),
								rs.getString("student_name"),
								rs.getString("class_name"),
								rs.getString("register_date"),
								rs.getString("status")
								
								),dto.getClassName());
			}else {
				String sql = "select * from student ";
				
				
				stuList=jdbcTemplate.query(
						sql, (rs, rowNum) -> new StudentResponseDTO(
								rs.getString("student_id"),
								rs.getString("student_name"),
								rs.getString("class_name"),
								rs.getString("register_date"),
								rs.getString("status")
								
								));
			}
		return stuList;
	}
}
