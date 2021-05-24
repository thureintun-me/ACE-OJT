package com.studentmanagement.dao;





import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.studentmanagement.dto.UserDTO;


public interface UserRepository extends CrudRepository<UserDTO, String> {

	@Query("select u from UserDTO u where u.userId=?1")
	List<UserDTO> selectById(String userId);
	@Query("select u from UserDTO u where u.userName = ?1")
	List<UserDTO> findByName(String name);
	
}
