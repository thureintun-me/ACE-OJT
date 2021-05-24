package studentmanagement.service;


import java.util.List;


import studentmanagement.dto.UserDTO;

public interface UserService {
	
	int insertUser(UserDTO dto);
	
	List<UserDTO> select(UserDTO dto);
	int updateUser(UserDTO dto);
	int deleteUser(UserDTO dto);
	

}
