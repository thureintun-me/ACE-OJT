package studentmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import studentmanagement.dto.StudentRequestDTO;
import studentmanagement.dto.StudentResponseDTO;


public class StudentServiceImpl implements StudentService {

	@Override
	public int insertStudent(StudentRequestDTO dto) {
		
		int result = 0;
		try(SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()){
			result=session.insert("studentnamespace.insertStudent", dto);
			session.commit();
		}catch (Exception e) {
			System.out.println("insert Error");
		}
		return result;
	}

	@Override
	public List<StudentResponseDTO> selectStudent(StudentRequestDTO dto) {
		List<StudentResponseDTO> list = new ArrayList<StudentResponseDTO>();
		try{
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			list=session.selectList("studentnamespace.selectStudent", dto);
			
		}catch (Exception e) {
			System.out.println("select error");
		}
		return list;
	}

	@Override
	public int deleteStudent(StudentRequestDTO dto) {
		int result = 0;
		try(SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()){
			result=session.delete("studentnamespace.deleteStudent", dto);
			session.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete Error");
		}
		return result;
	}

	@Override
	public int updateStudent(StudentRequestDTO dto) {
		int result = 0;
		try{
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			result=session.update("studentnamespace.updateStudent", dto);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("update error");
		}
		return result;
	}

}
