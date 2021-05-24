package studentmanagement.service;

import java.util.List;

import studentmanagement.dto.StudentRequestDTO;
import studentmanagement.dto.StudentResponseDTO;

public interface StudentService {

	int insertStudent(StudentRequestDTO dto);
	List<StudentResponseDTO> selectStudent(StudentRequestDTO dto);
	int deleteStudent(StudentRequestDTO dto);
	int updateStudent(StudentRequestDTO dto);
}
