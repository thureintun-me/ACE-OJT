package studentassingment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;


import studentassingment.dto.ClassDTO;

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
			System.out.println("bbbbbbb");
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
			
			
				clsList = em.createQuery("select c from ClassDTO c").getResultList();
			
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return clsList;
	}

	@Override
	public List<ClassDTO> selectOne(ClassDTO dto) {
		EntityManager em = null;
		List<ClassDTO> clsList = new ArrayList<ClassDTO>();
		ClassDTO cdto = new ClassDTO();
		 try {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();
			
			
				 cdto = (ClassDTO) em.createQuery("select c from ClassDTO c where c.classId=:id")
						.setParameter("id", dto.getClassId()).getResultList();
				
			clsList.add(cdto);
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return clsList;
	}

}
