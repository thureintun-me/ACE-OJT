package test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.thurein.model.StudentBean;

public class MyBatisUpdate {

	public static void main(String[] args) throws IOException {
		
		
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		
		StudentBean stu = new StudentBean();
		stu.setName("Ko Ko");
		stu.setBranch("Hledan");
		stu.setPhone(98788888);
		stu.setPercentage(30);
		stu.setEmail("ko@gmail.com");
		stu.setId(1);
		session.update("studnamespace.update", stu);
		session.commit();
		
		
		List<StudentBean> lstStudent = session.selectList("studnamespace.getAll");
		for (StudentBean st : lstStudent) {
		System.out.println(st);
		}
		session.close();
	}
}
