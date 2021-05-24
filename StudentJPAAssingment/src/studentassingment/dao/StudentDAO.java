package studentassingment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import studentassingment.dto.StudentDTO;
import studentassingment.dto.UserDTO;
import studentassingment.service.JPAUtil;
import studentassingment.service.StudentService;

public class StudentDAO implements StudentService {

	@Override
	public int insertStudent(StudentDTO dto) {
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
	public int updateStudent(StudentDTO dto) {
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
	public int deleteStudent(StudentDTO dto) {
		EntityManager em = null;
		int result =0;
		
		try {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();
			
			em.getTransaction().begin();
			StudentDTO outDTO = em.find(StudentDTO.class, dto.getStudentId());
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
	public List<StudentDTO> selectStudent(StudentDTO dto) {
		
		EntityManager em = null;
		List<StudentDTO> stuList = new ArrayList<StudentDTO>();
		 try {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();
			
			if(!dto.getStudentId().equals("")) {
			Query query = em.createQuery("select s from StudentDTO s where s.studentId=:id");
				stuList.add( (StudentDTO) query.setParameter("id", dto.getStudentId()).getSingleResult());
			}else if(!dto.getStudentName().equals("")) {
				Query query = em.createQuery("select s from StudentDTO s where s.studentName=:name");
				stuList =  query.setParameter("name", dto.getStudentName()).getResultList();
			}else if(!dto.getClassName().equals("")) {
				Query query = em.createQuery("select s from StudentDTO s where s.className=:name");
				stuList =  query.setParameter("name", dto.getClassName()).getResultList();
			}else {
				stuList = em.createQuery("select s from StudentDTO s").getResultList();
			}
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return stuList;
	}

}
