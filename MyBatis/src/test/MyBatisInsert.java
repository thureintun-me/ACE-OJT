package test;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.thurein.model.StudentBean;
public class MyBatisInsert {

	public static void main(String[] args) throws IOException {
		
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		
		StudentBean studentBean = new StudentBean(1,"Thu","Kamayut",1,456,"thu@gmail.com");
		session.insert("studnamespace.insert",studentBean);
		
		session.commit();
		session.close();
		
	}
}
