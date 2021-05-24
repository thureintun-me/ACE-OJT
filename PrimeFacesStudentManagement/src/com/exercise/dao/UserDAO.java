package com.exercise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exercise.dto.UserRequestDTO;
import com.exercise.dto.UserResponseDTO;





public class UserDAO {
	static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}

	public int insert(UserRequestDTO dto) {
		int result = 0;
		String sql = "insert into user (id,name,password) values(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getPassword());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int update(UserRequestDTO dto) {
		int result = 0;
		String sql = "update user set name=?,password=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(3, dto.getId());
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPassword());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int delete(UserRequestDTO dto) {
		int result = 0;
		String sql = "delete from user where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<UserResponseDTO> selectAll(){
		ArrayList<UserResponseDTO> list = new ArrayList<UserResponseDTO>();
		String sql = "select * from user";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UserResponseDTO dto = new UserResponseDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPassword(rs.getString("password"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Database Error");
			
		}
		return list;
	}
	public UserResponseDTO selectOne(UserRequestDTO dto){
		UserResponseDTO list = new UserResponseDTO();
		//System.out.println(dto.getId());
		String sql = "select * from user  where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				list.setId(rs.getString("id"));
				list.setName(rs.getString("name"));
				list.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Database Error");
			
		}
		return list;
	}
	
	public List<UserResponseDTO> select(UserRequestDTO dto) {
		List<UserResponseDTO> list = new ArrayList<UserResponseDTO>();

		try {
			PreparedStatement ps = con.prepareStatement("select * from user");
			if (!dto.getId().equals("")) {
				ps = con.prepareStatement("select * from user where id=?");
				ps.setString(1, dto.getId());
			} else if (!dto.getName().equals("")) {
				ps = con.prepareStatement("select * from user where name=?");
				ps.setString(1, dto.getName());
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserResponseDTO res = new UserResponseDTO();
				res.setId(rs.getString("id"));
				res.setName(rs.getString("name"));
				res.setPassword(rs.getString("password"));
				list.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public UserResponseDTO login(UserRequestDTO dto){
		UserResponseDTO list = new UserResponseDTO();
		//System.out.println(dto.getId());
		String sql = "select * from user  where id=? and password=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				list.setId(rs.getString("id"));
				list.setName(rs.getString("name"));
				list.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Database Error");
			
		}
		return list;
	}
	
	
}
