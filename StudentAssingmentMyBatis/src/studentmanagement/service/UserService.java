package studentmanagement.service;


import java.util.List;

import studentmanagement.dto.UserRequestDTO;
import studentmanagement.dto.UserResponseDTO;

public interface UserService {
	
	int insertUser(UserRequestDTO dto);
	
	List<UserResponseDTO> select(UserRequestDTO dto);
	int updateUser(UserRequestDTO dto);
	int deleteUser(UserRequestDTO dto);
	

}
