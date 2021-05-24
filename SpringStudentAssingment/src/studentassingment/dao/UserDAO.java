package studentassingment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import studentassingment.dto.UserDTO;
import studentassingment.service.JPAUtil;
import studentassingment.service.UserService;

public class UserDAO implements UserService {

	@Override
	public int insertUser(UserDTO dto) {
		EntityManager em = null;
		int result = 0;
		
		try {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();
			
			em.getTransaction().begin();
			em.persist(dto);
			em.getTransaction().commit();
			result = 1;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insetion Error!!!");
		}
		
		return result;
	}

	@Override
	public int updateUser(UserDTO dto) {
		EntityManager em = null;
		int result =0;
		
		try {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();
			
			em.getTransaction().begin();
			em.merge(dto);
			em.getTransaction().commit();
			result = 1;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Updating Error!!!");
		}
		
		return result;
	}

	@Override
	public int deleteUser(UserDTO dto) {
		EntityManager em = null;
		int result =0;
		
		try {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();
			
			em.getTransaction().begin();
			UserDTO outDTO = em.find(UserDTO.class, dto.getUserId());
			em.remove(outDTO);
			em.getTransaction().commit();
			result = 1;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Deletion Error!!!");
		}
		
		return result;
	}

	@Override
	public List<UserDTO> selectUser(UserDTO dto) {
		EntityManager em = null;
		List<UserDTO> usrList = new ArrayList<UserDTO>();
		 try {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();
			
			if(!dto.getUserId().equals("")) {
			Query query = em.createQuery("select u from UserDTO u where u.userId=:id");
				usrList.add( (UserDTO) query.setParameter("id", dto.getUserId()).getSingleResult());
			}else if(!dto.getUserName().equals("")) {
				Query query = em.createQuery("select u from UserDTO u where u.userName=:name");
				usrList =  query.setParameter("name", dto.getUserName()).getResultList();
			}else {
				usrList = em.createQuery("select u from UserDTO u").getResultList();
			}
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return usrList;
		
		
	}

}
