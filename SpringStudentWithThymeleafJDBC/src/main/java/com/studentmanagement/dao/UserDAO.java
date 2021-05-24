package com.studentmanagement.dao;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.studentmanagement.dto.UserRequestDTO;
import com.studentmanagement.dto.UserResponseDTO;



@Repository
public class UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public int insertUser(UserRequestDTO dto) {
		
		int result = 0;
		String sql = "insert into user(user_id,user_name,password) values (?,?,?) ";
		
		result = jdbcTemplate.update(sql,dto.getUserId(),dto.getUserName(),dto.getPassword());
		return result;
	}
	
	public int updateUser(UserRequestDTO dto) {
		int result = 0;
		String sql = "update user set user_name=?,password=? where user_id=?";
		result = jdbcTemplate.update(sql,dto.getUserName(),dto.getPassword(),dto.getUserId());
		

		System.out.println("id"+dto.getUserId());
		return result;
	}
	
	public int deleteUser(UserRequestDTO dto) {
		int result = 0;
		
		String sql = "delete from user where user_id = ?";
		result = jdbcTemplate.update(sql,dto.getUserId());
		return result;
	}
	
	public List<UserResponseDTO> selectUser(UserRequestDTO dto){
		List<UserResponseDTO> usrList = new ArrayList<UserResponseDTO>();
		
		
		if(!dto.getUserId().equals("")) {
			String sql = "select * from user where user_id=?";
			
			usrList=jdbcTemplate.query(
					sql, (rs, rowNum) -> new UserResponseDTO(rs.getString("user_id"),
							rs.getString("user_name"),
							rs.getString("password")),dto.getUserId());
			
			}else if(!dto.getUserName().equals("")) {
				String sql = "select * from user where user_name=?";
				
				
				usrList=jdbcTemplate.query(
						sql, (rs, rowNum) -> 
						new UserResponseDTO(rs.getString("user_id"),
								rs.getString("user_name"),
								rs.getString("password")),dto.getUserName());
			}else {
				String sql = "select * from user ";
				
				
				usrList=jdbcTemplate.query(
						sql, (rs, rowNum) -> 
						new UserResponseDTO(rs.getString("user_id"),
								rs.getString("user_name"),
								rs.getString("password")));
			}
		return usrList;
	}
}
