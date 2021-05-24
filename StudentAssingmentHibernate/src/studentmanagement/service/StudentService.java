package studentmanagement.service;

import java.util.List;


import studentmanagement.dto.StudentDTO;

public interface StudentService {

	int insertStudent(StudentDTO dto);
	List<StudentDTO> select(StudentDTO dto);
	int deleteStudent(StudentDTO dto);
	int updateStudent(StudentDTO dto);
}
