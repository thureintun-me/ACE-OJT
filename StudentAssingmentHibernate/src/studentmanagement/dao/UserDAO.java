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

import studentmanagement.dto.UserDTO;
import studentmanagement.service.UserService;

public class UserDAO implements UserService {

	@Override
	public int insertUser(UserDTO dto) {
		
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
	public int updateUser(UserDTO dto) {
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
	public int deleteUser(UserDTO dto) {
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
	public List<UserDTO> select(UserDTO dto) {
		Session session = null;
		
		
		List<UserDTO> usrList = new ArrayList<UserDTO>();
		
		try {
			session = HibernateUtil.getSeassionFactory().openSession();
		
			if (!dto.getUserId().equals("")) {
				UserDTO usr = new UserDTO();
				usr =(UserDTO)session.createQuery("from UserDTO  where user_id=:user_id")
						.setParameter("user_id", dto.getUserId()).getSingleResult();
				usrList.add(usr);
				
				
				
			} else if (!dto.getUserName().equals("")) {
				UserDTO usr = new UserDTO();
				usr =(UserDTO)session.createQuery("from UserDTO  where user_name=:user_name")
						.setParameter("user_name", dto.getUserName()).getSingleResult();
				usrList.add(usr);
			}else {
				usrList=session.createQuery("from UserDTO ").getResultList();
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		
		return usrList;	
		}

}
