package studentmanagement.service;

import java.util.List;

import studentmanagement.dto.ClassRequestDTO;
import studentmanagement.dto.ClassResponseDTO;


public interface ClassService {

	int classInsert(ClassRequestDTO dto);
	List<ClassResponseDTO> select(ClassRequestDTO dto);
}
