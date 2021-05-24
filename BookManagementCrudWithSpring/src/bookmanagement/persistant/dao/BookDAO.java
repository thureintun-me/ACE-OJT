package bookmanagement.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import bookmanagement.persistant.dto.BookRequestDTO;
import bookmanagement.persistant.dto.BookResponseDTO;

public class BookDAO {
	
	static Connection con = null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	public int insert(BookRequestDTO dto) {
		int result =0;
		String sql = "insert into book(book_code,book_title,book_author,book_price)"+
		"values(?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBookCode());
			ps.setString(2, dto.getBookTitle());
			ps.setString(3, dto.getBookAuthor());
			ps.setDouble(4, dto.getBookPrice());
			result = ps.executeUpdate();
		
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insertion Error");
		}
		return result;
	}
	
	public int update(BookRequestDTO dto) {
		int result =0;
		String sql = "update book set book_title=?,book_author=?,book_price=? where book_code=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(4, dto.getBookCode());
			ps.setString(1, dto.getBookTitle());
			ps.setString(2, dto.getBookAuthor());
			ps.setDouble(3, dto.getBookPrice());
			result = ps.executeUpdate();
		
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update Error");
		}
		return result;
	}
	
	public int delete(BookRequestDTO dto) {
		int result = 0;
		String sql = "delete from book where book_code=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBookCode());
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete Error");
		}
		return result;
	}
	
	public BookResponseDTO selectOne(BookRequestDTO dto) {
		
		BookResponseDTO res = new BookResponseDTO();
		String sql = "select * from book where book_code=?";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBookCode());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				res.setBookCode(rs.getString("book_code"));
				res.setBookTitle(rs.getString("book_title"));
				res.setBookAuthor(rs.getString("book_author"));
				res.setBookPrice(rs.getDouble("book_price"));
				
			}
		}catch (Exception e) {
			System.out.println("Database Error");
		}
		return res;
	}
	
	public ArrayList<BookResponseDTO> selectAll(){
		
		ArrayList<BookResponseDTO> list = new ArrayList();
		String sql = "select * from book";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BookResponseDTO res = new BookResponseDTO();
				res.setBookCode(rs.getString("book_code"));
				res.setBookTitle(rs.getString("book_title"));
				res.setBookAuthor(rs.getString("book_author"));
				res.setBookPrice(rs.getDouble("book_price"));
				list.add(res);
			}
		}catch (Exception e) {
			System.out.println("Database Error");
		}
		return list;
	}
	
}
