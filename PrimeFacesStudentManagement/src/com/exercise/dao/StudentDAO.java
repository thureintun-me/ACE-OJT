package com.exercise.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.exercise.dto.StudentDTO;

public class StudentDAO {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}

	public int insertData(StudentDTO dto) {
		int result = 0;
		String sql = "insert into student(student_id,student_name,class_name,register_date,status)"
				+ "values(?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getClassName());
			/*
			 * DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); String
			 * registerDate=dateFormat.format(dto.getRegisterDate()); Date
			 * date=Date.valueOf(registerDate);
			 */
			ps.setDate(4, new Date(dto.getRegisterDate().getTime()));

			ps.setString(5, dto.getStatus());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
	}

	public int updateData(StudentDTO dto) {
		int result = 0;
		String sql = "update student set student_name=?,class_name=?,register_date=?,status=?"

				+ "where student_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, dto.getName());
			ps.setString(2, dto.getClassName());

			ps.setDate(3, new Date(dto.getRegisterDate().getTime()));
			ps.setString(4, dto.getStatus());
			ps.setString(5, dto.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
	}

	public int deleteData(StudentDTO dto) {
		int result = 0;
		String sql = "delete from student where student_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
	}

	public StudentDTO selectOne(StudentDTO dto) {
		StudentDTO res = new StudentDTO();
		String sql = "select * from student where student_id=?";
		System.out.println(dto.getId());
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				res.setId(rs.getString("student_id"));
				res.setName(rs.getString("student_name"));
				res.setClassName(rs.getString("class_name"));
				res.setRegisterDate(rs.getDate("register_date"));
				res.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public ArrayList<StudentDTO> selectAll() {
		ArrayList<StudentDTO> list = new ArrayList();
		String sql = "select * from student";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentDTO res = new StudentDTO();
				res.setId(rs.getString("student_id"));
				res.setName(rs.getString("student_name"));
				res.setClassName(rs.getString("class_name"));
				res.setRegisterDate(rs.getDate("register_date"));
				res.setStatus(rs.getString("status"));
				list.add(res);
			}
		} catch (SQLException e) {
//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	public ArrayList<StudentDTO> select(StudentDTO dto)  {
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		try {
			PreparedStatement ps;
			if (!dto.getId().equals("")) {
				System.out.println("sql1");
				ps = con.prepareStatement("select * from student where student_id=?");
				ps.setString(1, dto.getId());
			} else if (!dto.getName().equals("")) {
				System.out.println("sql2");
				ps = con.prepareStatement("select * from student where student_name=?");
				ps.setString(1, dto.getName());
			} else if (!dto.getClassName().equals("")) {
				System.out.println("sql3");
				ps = con.prepareStatement("select * from student where class_name=?");
				ps.setString(1, dto.getClassName());
			}else {
				ps = con.prepareStatement("select * from student");
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentDTO res = new StudentDTO();
				res.setId(rs.getString("student_id"));
				res.setName(rs.getString("student_name"));
				res.setClassName(rs.getString("class_name"));
				res.setRegisterDate(rs.getDate("register_date"));
				res.setStatus(rs.getString("status"));
				list.add(res);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		return list;

	}
}
