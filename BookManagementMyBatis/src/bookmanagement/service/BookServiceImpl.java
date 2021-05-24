package bookmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bookmanagement.persistant.dto.BookRequestDTO;
import bookmanagement.persistant.dto.BookResponseDTO;

public class BookServiceImpl implements BookService {

	@Override
	public int insertData(BookRequestDTO dto) {
		int result = 0;
			try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()){
				result = session.insert("booknamespace.insert",dto);
				session.commit();
				
				
				
			}
		return result;
	}

	@Override
	public int updateData(BookRequestDTO dto) {
		int result = 0;
		try(SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()){
			result=session.update("booknamespace.update",dto);
			session.commit();
		}
		return result;
	}

	@Override
	public int deleteData(BookRequestDTO dto) {
		int result = 0;
		try(SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()){
			result=session.delete("booknamespace.delete",dto);
			session.commit();
		}
		return result;
	}

	@Override
	public BookResponseDTO selectOne(BookRequestDTO dto) {
		
		BookResponseDTO res = new BookResponseDTO();
		try(SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()){
			res=session.selectOne("booknamespace.selectOne",dto);
		}
		return res;
	}

	@Override
	public List<BookResponseDTO> selectAll() {
		
		List<BookResponseDTO> list = new ArrayList<BookResponseDTO>();
		try(SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()){
			list=session.selectList("booknamespace.selectAll");
		}
		return list;
	}

}
