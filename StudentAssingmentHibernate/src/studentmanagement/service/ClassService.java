package studentmanagement.service;

import java.util.List;


import studentmanagement.dto.ClassDTO;


public interface ClassService {

	int insertClass(ClassDTO dto);
	int deleteClass(ClassDTO dto);
	int updateClass(ClassDTO dto);
	List<ClassDTO> select(ClassDTO dto);
}
