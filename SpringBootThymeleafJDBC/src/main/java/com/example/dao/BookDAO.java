package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dto.BookRequestDTO;
import com.example.dto.BookResponseDTO;

@Repository
public class BookDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int insertData(BookRequestDTO dto) {
		int result = 0;
		String sql = "insert into book(book_code,book_title,book_author,book_price) values(?,?,?,?)";

		result = jdbcTemplate.update(sql,

				dto.getBookCode(), dto.getBookTitle(), dto.getBookAuthor(), dto.getBookPrice());

		return result;
	}

	public int updateData(BookRequestDTO dto) {
		int result = 0;
		String sql = "update book set book_title=?,book_author=?,book_price=?" + "where book_code=?";
		result = jdbcTemplate.update(sql,

				dto.getBookTitle(), dto.getBookAuthor(), dto.getBookPrice(), dto.getBookCode());

		return result;
	}

	public int deleteData(BookRequestDTO dto) {
		int result = 0;
		String sql = "delete from book where book_code=?";
		result = jdbcTemplate.update(sql, dto.getBookCode());
		return result;
	}

	public BookResponseDTO selectOne(BookRequestDTO dto) {
		String sql = "select * from book where book_code=?";
		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new BookResponseDTO(

				rs.getString("book_code"), rs.getString("book_title"), rs.getString("book_author"),
				rs.getDouble("book_price")), dto.getBookCode());

	}

	public List<BookResponseDTO> selectAll() {
		String sql = "select * from book";
		return jdbcTemplate.query(

				sql, (rs, rowNum) -> new BookResponseDTO(rs.getString("book_code"), rs.getString("book_title"),
						rs.getString("book_author"), rs.getDouble("book_price")

				));
	}

}
