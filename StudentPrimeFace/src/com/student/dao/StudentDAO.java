package com.student.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.student.dto.StudentDTO;
import com.student.service.JPAUtil;
import com.student.service.StudentService;



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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudent(StudentDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StudentDTO> selectStudent(StudentDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
