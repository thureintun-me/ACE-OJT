package studentmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import studentmanagement.dto.StudentDTO;
import studentmanagement.dto.UserDTO;
import studentmanagement.service.StudentService;

public class StudentDAO implements StudentService{

	@Override
	public int insertStudent(StudentDTO dto) {
		Session session = null;
		Transaction tran = null;
		int result =0;
		
		try {
			StandardServiceRegistry ssr = new  StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory factory = meta.getSessionFactoryBuilder().build();
			session = factory.openSession();
			tran = session.beginTransaction();
			session.persist(dto);
			tran.commit();
			result = 1;
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}

	@Override
	public List<StudentDTO> select(StudentDTO dto) {
		Session session = null;
		
		
		List<StudentDTO> stdList = new ArrayList<StudentDTO>();
		
		try {
			session = HibernateUtil.getSeassionFactory().openSession();
		
			if (!dto.getStudentId().equals("")) {
				
				StudentDTO std = new StudentDTO();
				std =(StudentDTO)session.createQuery("from StudentDTO  where student_id=:student_id")
						.setParameter("student_id", dto.getStudentId()).getSingleResult();
				stdList.add(std);
				
				
			}else if (!dto.getStudentName().equals("")) {
				
				stdList =session.createQuery("from StudentDTO  where student_name=:student_name")
						.setParameter("student_name", dto.getStudentName()).getResultList();
				
			}else if(!dto.getClassName().equals("")){
				
				stdList =session.createQuery("from StudentDTO  where class_name=:class_name")
						.setParameter("class_name", dto.getClassName()).getResultList();
				
			}else{
				stdList=session.createQuery("from StudentDTO ").getResultList();
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		
		return stdList;	
		}
	

	@Override
	public int deleteStudent(StudentDTO dto) {
		
		Session session = null;
		Transaction tran = null;
		int result =0;
		
		try {
			session = HibernateUtil.getSeassionFactory().openSession();
			tran = session.beginTransaction();
			session.delete(dto);
			tran.commit();
			result = 1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}

	@Override
	public int updateStudent(StudentDTO dto) {
		Session session = null;
		Transaction tran = null;
		int result =0;
		
		try {
			session = HibernateUtil.getSeassionFactory().openSession();
			tran = session.beginTransaction();
			session.update(dto);
			tran.commit();
			result = 1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return result;
	}

	
}
