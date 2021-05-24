package bookmanagement.service;

import java.util.List;

import bookmanagement.persistant.dto.BookRequestDTO;
import bookmanagement.persistant.dto.BookResponseDTO;

public interface BookService {

	public int insertData(BookRequestDTO dto) ;
	public int updateData(BookRequestDTO dto);
	public int deleteData(BookRequestDTO dto);
	public BookResponseDTO selectOne(BookRequestDTO dto);
	public List<BookResponseDTO> selectAll();
}
