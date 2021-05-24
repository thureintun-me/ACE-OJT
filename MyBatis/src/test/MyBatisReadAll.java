package test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.thurein.model.StudentBean;

public class MyBatisReadAll {

	public static void main(String[] args) throws IOException {
		
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		
		/*
		 * List<StudentBean> lstStudent = session.selectList("studnamespace.getAll");
		 * for (StudentBean st : lstStudent) { System.out.println(st); }
		 */
		
		StudentBean student = session.selectOne("studnamespace.getById", 1);
		System.out.println(student);
	}
}
