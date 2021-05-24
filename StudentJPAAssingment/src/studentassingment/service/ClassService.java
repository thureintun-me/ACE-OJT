package studentassingment.service;

import java.util.List;

import studentassingment.dto.ClassDTO;

public interface ClassService {

	int insertClass(ClassDTO dto);
	
	List<ClassDTO> selectClass(ClassDTO dto);
}
