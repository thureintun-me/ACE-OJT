package bookmanagement.service;

import java.io.Reader;

import org.apache.ibatis.io.Resources;

	
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	static SqlSessionFactory factory;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			factory=new SqlSessionFactoryBuilder().build(reader);
			
		}catch (Exception e) {
			System.out.println("not found");
		}
		return factory;
	}
}
