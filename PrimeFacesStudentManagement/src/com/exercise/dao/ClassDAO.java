package com.exercise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.exercise.dto.ClassDTO;

public class ClassDAO {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}

	public int insertData(ClassDTO dto) {
		int result = 0;
		String sql = "insert into class(id,name)" + "values(?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
	}

	public ArrayList<ClassDTO> selectAll() {
		ArrayList<ClassDTO> list = new ArrayList<ClassDTO>();
		String sql = "select * from class";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ClassDTO res = new ClassDTO();
				res.setId(rs.getString("id"));
				res.setName(rs.getString("name"));

				list.add(res);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<ClassDTO> selectOne(ClassDTO dto) {
		ArrayList<ClassDTO> list = new ArrayList<ClassDTO>();
		if(dto.getId()!=null) {
			
			String sql = "select * from class where id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, dto.getId());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					ClassDTO res = new ClassDTO();
					res.setId(rs.getString("id"));
					res.setName(rs.getString("name"));

					list.add(res);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		return list;
	}

}
