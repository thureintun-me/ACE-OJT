package studentmanagement.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import studentmanagement.dto.UserRequestDTO;
import studentmanagement.dto.UserResponseDTO;

public class UserServiceImpl implements UserService {

	@Override
	public int insertUser(UserRequestDTO dto) {
		

		int result = 0;
		try{
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			result=session.insert("usernamespace.insertUser", dto);
			session.commit();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	
	

	@Override
	public List<UserResponseDTO> select(UserRequestDTO dto) {
		List<UserResponseDTO> list = new ArrayList<UserResponseDTO>();
		try{
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			list=session.selectList("usernamespace.selectUser", dto);
			
		}catch (Exception e) {
			System.out.println("select error");
		}
		return list;
	}

	@Override
	public int updateUser(UserRequestDTO dto) {
		
		
		int result = 0;
		try{
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			result=session.update("usernamespace.updateUser", dto);
			session.commit();
		}catch (Exception e) {
			System.out.println("update error");
		}
		return result;
	}

	@Override
	public int deleteUser(UserRequestDTO dto) {
		
		int result = 0;
		try{
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			result=session.delete("usernamespace.deleteUser", dto);
			session.commit();
		}catch (Exception e) {
			System.out.println("delete error error");
		}
		return result;
		
	}

	
	

}
