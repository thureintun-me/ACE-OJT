package com.studentmanagement.controller;




import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studentmanagement.dao.ClassDAO;
import com.studentmanagement.dao.StudentDAO;
import com.studentmanagement.dto.ClassRequestDTO;
import com.studentmanagement.dto.ClassResponseDTO;
import com.studentmanagement.dto.StudentRequestDTO;
import com.studentmanagement.dto.StudentResponseDTO;
import com.studentmanagement.model.StudentBean;




@Controller
public class StudentController {

	@Autowired
	ClassDAO classDAO = new ClassDAO();
	@Autowired
	StudentDAO stuDAO = new StudentDAO();
	
	
	
	@RequestMapping(value = "/studentSearch",method = RequestMethod.GET)
	public ModelAndView studentSearh() {
		return new ModelAndView("BUD001","stuBean",new StudentBean());
	}
	
	
	
	@RequestMapping(value = "/setupAddStudent",method = RequestMethod.GET)
	public ModelAndView setupAddStudent(ModelMap model,HttpSession session) {
		
		ClassRequestDTO dto = new ClassRequestDTO();
		dto.setClassId("");
		dto.setClassName("");
		List<ClassResponseDTO> clsList = classDAO.selectClass(dto);
		
		session.setAttribute("clsList", clsList);
		
		
		return new ModelAndView("BUD002","bean",new StudentBean());
	}
	
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("bean") @Validated StudentBean bean, BindingResult result, RedirectAttributes rAttributes) {
		if (result.hasErrors()) {
			return "BUD002";
		}

		
			
			
			StudentRequestDTO dto = new StudentRequestDTO();
			StudentRequestDTO sdto = new StudentRequestDTO();
			sdto.setStudentId(bean.getStudentId());
			dto.setStudentId(bean.getStudentId());
			dto.setStudentName(bean.getStudentName());
			dto.setClassName(bean.getClassName());
			dto.setStatus(bean.getStatus());
			dto.setRegisterDate(bean.getYear()+"-"+bean.getMonth()+"-"+bean.getDay());
			List<StudentResponseDTO> stuList = stuDAO.selectStudent(dto);
			if (stuList.size() != 0) {
					rAttributes.addFlashAttribute("err", "Duplicate student id  ");
				return "redirect:/setupAddStudent";
			} else {

				int rs = stuDAO.insertStudent(dto);

				if (rs == 0) {
					rAttributes.addFlashAttribute("err", "Insertion failed");
					return "redirect:/setupAddStudent";
				} else {
					rAttributes.addFlashAttribute("msg", "Insert Successful");
					return "redirect:/setupAddStudent";

				}
			}

		} 

	@RequestMapping(value="/studentSearchResult",method={RequestMethod.GET, RequestMethod.PUT})
	public String searchStudent(@ModelAttribute("stuBean") StudentBean stuBean,ModelMap model) {
		
		
		StudentRequestDTO dto = new StudentRequestDTO();
		dto.setStudentId(stuBean.getStudentId());
		dto.setStudentName(stuBean.getStudentName());
		dto.setClassName(stuBean.getClassName());
		
		List<StudentResponseDTO> stuList = stuDAO.selectStudent(dto);
	
		
		if(stuList.size() ==0) {
			model.addAttribute("msg", "Student not found");
			return "BUD001";
		}else {
			model.addAttribute("stulist", stuList);
			return "BUD001";
		}
			
		
		
		
	}
	@RequestMapping(value = "/setupUpdateStudent",method = RequestMethod.GET)
	public ModelAndView setupUpdateBook(@RequestParam("studentName") String studentName,ModelMap model) {
		
		
		StudentRequestDTO dto = new StudentRequestDTO(); 
		
		dto.setClassName("");
		dto.setStudentId("");
		dto.setStudentName(studentName);
		
		List<StudentResponseDTO> stulist = stuDAO.selectStudent(dto);
		StudentBean stu = new StudentBean();
		for(StudentResponseDTO u:stulist) {
			stu.setStudentId(u.getStudentId());
			stu.setStudentName(u.getStudentName());
			stu.setClassName(u.getClassName());
			stu.setStatus(u.getStatus());
			stu.setYear(u.getRegisterDate().substring(0, 4));
			stu.setMonth(u.getRegisterDate().substring(5, 7));
			stu.setDay(u.getRegisterDate().substring(8, 10));
		}
		return new ModelAndView("BUD002-01","bean",stu);
	}
	
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute("bean") @Validated StudentBean bean, BindingResult result, RedirectAttributes rAttributes) {
		if (result.hasErrors()) {
			return "USR002";
		}

		
			
			
			StudentRequestDTO dto = new StudentRequestDTO();
			StudentRequestDTO sdto = new StudentRequestDTO();
			sdto.setStudentId(bean.getStudentId());
			dto.setStudentId(bean.getStudentId());
			dto.setStudentName(bean.getStudentName());
			dto.setClassName(bean.getClassName());
			dto.setStatus(bean.getStatus());
			dto.setRegisterDate(bean.getYear()+"-"+bean.getMonth()+"-"+bean.getDay());
			
			 

				int rs = stuDAO.updateStudent(dto);

				if (rs == 0) {
					rAttributes.addFlashAttribute("err", "update failed");
					return "redirect:/setupAddStudent";
				} else {
					rAttributes.addFlashAttribute("msg", "Update Successful");
					return "redirect:/setupAddStudent";

				}
			}

		
	@RequestMapping(value="/studentDelete",method = RequestMethod.GET)
	public String deleteUser(@RequestParam("studentId")String studentId,RedirectAttributes rAttributes) {
		
		StudentRequestDTO dto = new StudentRequestDTO();
		
		dto.setStudentId(studentId);
		int counter = stuDAO.deleteStudent(dto);
		
		if(counter ==0) {
			rAttributes.addFlashAttribute("err", "delete fail....");
			return "redirect:/studentSearch";
		}else {
			rAttributes.addFlashAttribute("msg", "Successfully Deleted....");
			return "redirect:/studentSearch";
		}
		
	}
	
	
}
