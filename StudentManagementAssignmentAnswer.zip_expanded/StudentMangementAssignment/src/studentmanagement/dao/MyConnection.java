package studentmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static Connection con = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "mo@12691");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Class not found");
		} catch (SQLException e) {
			System.out.println("Database connection not found");
		}
		return con;
	}

}
