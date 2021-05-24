package com.studentmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

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

import com.studentmanagement.dao.ClassService;

import com.studentmanagement.dao.StudentService;
import com.studentmanagement.dto.ClassDTO;

import com.studentmanagement.dto.StudentDTO;

import com.studentmanagement.model.StudentBean;

@Controller
public class StudentController {

	@Autowired
	ClassService classService;
	@Autowired
	StudentService stuService;
	@Autowired
	ServletContext context;
	@RequestMapping(value = "/studentSearch", method = RequestMethod.GET)
	public ModelAndView studentSearh() {
		return new ModelAndView("BUD001", "stuBean", new StudentBean());
	}

	@RequestMapping(value = "/setupAddStudent", method = RequestMethod.GET)
	public ModelAndView setupAddStudent(ModelMap model) {
		List<ClassDTO> clsList = classService.getAllClass();
		
		
		context.setAttribute("clsList", clsList);
		
		return new ModelAndView("BUD002", "bean", new StudentBean());
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("bean") @Validated StudentBean bean, BindingResult result,
			RedirectAttributes rAttributes) {
		if (result.hasErrors()) {
			return "BUD002";
		}

		StudentDTO dto = new StudentDTO();

		dto.setStudentId(bean.getStudentId());
		dto.setStudentName(bean.getStudentName());
		dto.setClassName(bean.getClassName());
		dto.setStatus(bean.getStatus());
		dto.setRegisterDate(bean.getYear() + "-" + bean.getMonth() + "-" + bean.getDay());
		List<StudentDTO> stuList = stuService.findById(dto.getStudentId());
		if (stuList.size()!=0) {
			rAttributes.addFlashAttribute("err", "Duplicate student id  ");
			return "redirect:/setupAddStudent";
		} else {

			stuService.insertStudent(dto);

			rAttributes.addFlashAttribute("msg", "Insert Successful");
			return "redirect:/setupAddStudent";

		}

	}

	@RequestMapping(value = "/studentSearchResult", method = { RequestMethod.GET, RequestMethod.PUT })
	public String searchStudent(@ModelAttribute("stuBean") StudentBean stuBean, ModelMap model) {

		StudentDTO dto = new StudentDTO();
		dto.setStudentId(stuBean.getStudentId());
		dto.setStudentName(stuBean.getStudentName());
		dto.setClassName(stuBean.getClassName());
		List<StudentDTO> stuList = new ArrayList<StudentDTO>();
		if (!dto.getStudentId().equals("")) {
			 stuList = stuService.findById(dto.getStudentId());
			
		} else if (!dto.getStudentName().equals("")) {
			stuList = stuService.findByName(dto.getStudentName());
		} else if (!dto.getClassName().equals("")) {
			stuList = stuService.findByClass(dto.getClassName());
		} else {
			stuList = stuService.getAllStudent();
		}

		if (stuList.size() == 0) {
			model.addAttribute("msg", "Student not found");
			return "BUD001";
		} else {
			model.addAttribute("stulist", stuList);
			return "BUD001";
		}

	}

	@RequestMapping(value = "/setupUpdateStudent", method = RequestMethod.GET)
	public ModelAndView setupUpdateStudent(@RequestParam("studentName") String studentName, ModelMap model) {
		

		StudentDTO dto = new StudentDTO();

		dto.setStudentName(studentName);
		List<ClassDTO> clsList = classService.getAllClass();
		context.setAttribute("clsList", clsList);
		

		List<StudentDTO> stulist = stuService.findByName(dto.getStudentName());
		StudentBean stu = new StudentBean();
		for (StudentDTO u : stulist) {
			stu.setStudentId(u.getStudentId());
			stu.setStudentName(u.getStudentName());
			stu.setClassName(u.getClassName());
			stu.setStatus(u.getStatus());
			stu.setYear(u.getRegisterDate().substring(0, 4));
			stu.setMonth(u.getRegisterDate().substring(5, 7));
			stu.setDay(u.getRegisterDate().substring(8, 10));
		}
		
		return new ModelAndView("BUD002-01", "bean", stu);
	}

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute("bean") @Validated StudentBean bean, BindingResult result,
			RedirectAttributes rAttributes) {
		if (result.hasErrors()) {
			return "BUD002-01";
		}

		StudentDTO dto = new StudentDTO();

		dto.setStudentId(bean.getStudentId());
		dto.setStudentName(bean.getStudentName());
		dto.setClassName(bean.getClassName());
		dto.setStatus(bean.getStatus());
		dto.setRegisterDate(bean.getYear() + "-" + bean.getMonth() + "-" + bean.getDay());

		stuService.updateStudent(dto, dto.getStudentId());
		;

		rAttributes.addFlashAttribute("msg", "Update Successful");
		return "redirect:/studentSearch";

	}

	@RequestMapping(value = "/studentDelete", method = RequestMethod.GET)
	public String deleteStudent(@RequestParam("studentId") String studentId, RedirectAttributes rAttributes) {

		StudentDTO dto = new StudentDTO();

		dto.setStudentId(studentId);
		stuService.deleteStudent(dto.getStudentId());

		rAttributes.addFlashAttribute("msg", "Successfully Deleted....");
		return "redirect:/studentSearch";
	}

}
