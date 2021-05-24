package studentassingment.service;

import java.util.List;

import studentassingment.dto.StudentDTO;


public interface StudentService {

	int insertStudent(StudentDTO dto);
	int updateStudent(StudentDTO dto);
	int deleteStudent(StudentDTO dto);
	List<StudentDTO> selectStudent(StudentDTO dto);
}
