package studentassingment.service;

import java.util.List;

import org.apache.tomcat.jni.User;

import studentassingment.dto.UserDTO;

public interface UserService {
	
	int insertUser(UserDTO dto);
	int updateUser(UserDTO dto);
	int deleteUser(UserDTO dto);
	List<UserDTO> selectUser(UserDTO dto);

}
