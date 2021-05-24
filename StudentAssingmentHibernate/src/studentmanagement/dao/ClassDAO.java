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

import studentmanagement.dto.ClassDTO;

import studentmanagement.service.ClassService;

public class ClassDAO implements ClassService {

	@Override
	public int insertClass(ClassDTO dto) {
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
	public int deleteClass(ClassDTO dto) {
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
	public int updateClass(ClassDTO dto) {
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
	

	@Override
	public List<ClassDTO> select(ClassDTO dto) {
		
		Session session = null;
		
		
		List<ClassDTO> clsList = new ArrayList<ClassDTO>();
		
		try {
			session = HibernateUtil.getSeassionFactory().openSession();
		
			if (!dto.getClassId().equals("")) {
				ClassDTO cls = new ClassDTO();
				cls =(ClassDTO)session.createQuery("from ClassDTO  where class_id=:class_id")
						.setParameter("class_id", dto.getClassId()).getSingleResult();
				clsList.add(cls);
				
				
				
			} else if (!dto.getClassName().equals("")) {
				ClassDTO cls = new ClassDTO();
				cls =(ClassDTO)session.createQuery("from ClassDTO  where class_name=:class_name")
						.setParameter("class_name", dto.getClassName()).getSingleResult();
				clsList.add(cls);
			}else {
				clsList=session.createQuery("from ClassDTO ").getResultList();
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		
		return clsList;	
		}

	
}
