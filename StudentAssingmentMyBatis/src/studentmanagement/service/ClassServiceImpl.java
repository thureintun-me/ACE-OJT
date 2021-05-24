package studentmanagement.service;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import studentmanagement.dto.ClassRequestDTO;
import studentmanagement.dto.ClassResponseDTO;

public class ClassServiceImpl implements ClassService {

	@Override
	public int classInsert(ClassRequestDTO dto) {
		int result = 0;
		try{
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			result=session.insert("classnamespace.insertClass", dto);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert Error");
		}
		return result;
	}

	@Override
	public List<ClassResponseDTO> select(ClassRequestDTO dto) {
		 List<ClassResponseDTO> list = new ArrayList<ClassResponseDTO>();
		 
		 try{
				SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
				list=session.selectList("classnamespace.selectClass",dto);
				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("select error");
			}
			return list;	

}
}
