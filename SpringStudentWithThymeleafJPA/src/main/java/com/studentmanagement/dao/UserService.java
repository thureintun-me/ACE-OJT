package com.studentmanagement.dao;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.studentmanagement.dto.UserDTO;



@Service
public class UserService   {

	@Autowired
	UserRepository userRepository;

	public void insertUser(UserDTO dto) {
		userRepository.save(dto);
		
	}
	
	public void updateUser(UserDTO dto,String userId) {
		userRepository.save(dto);
	}
	
	public void deleteUser(String  userId) {
		userRepository.deleteById(userId);
		
	}
	
	public List<UserDTO> getAllUser(){
		List<UserDTO> list = (List<UserDTO>) userRepository.findAll();
		return list;
	}
	
	public List<UserDTO> findById(String userId){
		return userRepository.selectById(userId);
	}
	
	public List<UserDTO> findByName(String userName) {
		return userRepository.findByName(userName);
		
	}

	
}
