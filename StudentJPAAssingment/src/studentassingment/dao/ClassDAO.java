package studentassingment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import studentassingment.dto.ClassDTO;
import studentassingment.dto.UserDTO;
import studentassingment.service.ClassService;
import studentassingment.service.JPAUtil;

public class ClassDAO implements ClassService {

	@Override
	public int insertClass(ClassDTO dto) {
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
	public List<ClassDTO> selectClass(ClassDTO dto) {
		EntityManager em = null;
		List<ClassDTO> clsList = new ArrayList<ClassDTO>();
		 try {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();
			if(!dto.getClassId().equals("")) {
				Query query = em.createQuery("sselect c from ClassDTO c where c.classId=:id");
					clsList.add( (ClassDTO) query.setParameter("id", dto.getClassId()).getSingleResult());
				}else {
					
					clsList = em.createQuery("select c from ClassDTO c ").getResultList();
				}
			
				
			
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return clsList;
	}

}
