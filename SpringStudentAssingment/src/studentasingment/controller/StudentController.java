package studentasingment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import studentassingment.dao.ClassDAO;
import studentassingment.dao.StudentDAO;
import studentassingment.dao.UserDAO;
import studentassingment.dto.ClassDTO;
import studentassingment.dto.StudentDTO;
import studentassingment.dto.UserDTO;
import studentmanagement.model.StudentBean;
import studentmanagement.model.UserBean;

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
	public ModelAndView setupAddStudent(ModelMap model) {
		
		ClassDTO dto = new ClassDTO();
		List<ClassDTO> clsList = classDAO.selectClass(dto);
		
		model.addAttribute("classlist", clsList);
		return new ModelAndView("BUD002","bean",new StudentBean());
	}
	
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("bean") @Validated StudentBean bean, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "BUD002";
		}

		
			
			
			StudentDTO dto = new StudentDTO();
			StudentDTO sdto = new StudentDTO();
			sdto.setStudentId(bean.getStudentId());
			dto.setStudentId(bean.getStudentId());
			dto.setStudentName(bean.getStudentName());
			dto.setClassName(bean.getClassName());
			dto.setStatus(bean.getStatus());
			dto.setRegisterDate(bean.getYear()+"-"+bean.getMonth()+"-"+bean.getDay());
			List<StudentDTO> stuList = stuDAO.selectStudent(sdto);
			if (stuList.size() != 0) {
				model.addAttribute("err", "Duplicate student id  ");
				return "redirect:/setupAddStudent";
			} else {

				int rs = stuDAO.insertStudent(dto);

				if (rs == 0) {
					model.addAttribute("err", "Insertion failed");
					return "redirect:/setupAddStudent";
				} else {
					model.addAttribute("msg", "Insert Successful");
					return "redirect:/setupAddStudent";

				}
			}

		} 

	@RequestMapping(value="/studentSearchResult",method={RequestMethod.GET, RequestMethod.PUT})
	public String searchUser(@ModelAttribute("stuBean") StudentBean stuBean,ModelMap model) {
		
		
		StudentDTO dto = new StudentDTO();
		dto.setStudentId(stuBean.getStudentId());
		dto.setStudentName(stuBean.getStudentName());
		dto.setClassName(stuBean.getClassName());
		
		List<StudentDTO> stuList = stuDAO.selectStudent(dto);
		
		if(stuList.size() ==0) {
			model.addAttribute("msg", "Student not found");
			return "BUD001";
		}else {
			model.addAttribute("stulist", stuList);
			return "BUD001";
		}
			
		
		
		
	}
	@RequestMapping(value = "/setupUpdateStudent/{studentName}",method = RequestMethod.GET)
	public ModelAndView setupUpdateBook(@PathVariable String studentName,ModelMap model) {
		ClassDAO cdao = new ClassDAO();
		ClassDTO cdto = new ClassDTO();
		List<ClassDTO> clsList = cdao.selectClass(cdto);
		System.out.println("size : " + clsList.size());
		model.addAttribute("classlist", clsList);
		
		StudentDTO dto = new StudentDTO(); 
		StudentDAO dao = new StudentDAO();
		dto.setClassName("");
		dto.setStudentId("");
		dto.setStudentName(studentName);
		
		List<StudentDTO> stulist = dao.selectStudent(dto);
		StudentBean stu = new StudentBean();
		for(StudentDTO u:stulist) {
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
	public String updateStudent(@ModelAttribute("bean") @Validated StudentBean bean, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "USR002";
		}

		
			
			StudentDAO dao = new StudentDAO();
			StudentDTO dto = new StudentDTO();
			StudentDTO sdto = new StudentDTO();
			sdto.setStudentId(bean.getStudentId());
			dto.setStudentId(bean.getStudentId());
			dto.setStudentName(bean.getStudentName());
			dto.setClassName(bean.getClassName());
			dto.setStatus(bean.getStatus());
			dto.setRegisterDate(bean.getYear()+"-"+bean.getMonth()+"-"+bean.getDay());
			
			 

				int rs = dao.updateStudent(dto);

				if (rs == 0) {
					model.addAttribute("err", "update failed");
					return "redirect:/setupAddStudent";
				} else {
					model.addAttribute("msg", "Update Successful");
					return "redirect:/setupAddStudent";

				}
			}

		
	@RequestMapping(value="/studentDelete/{studentId}",method = RequestMethod.GET)
	public String deleteUser(@PathVariable("studentId")String studentId,ModelMap model) {
		
		StudentDTO dto = new StudentDTO();
		StudentDAO dao = new StudentDAO();
		dto.setStudentId(studentId);
		int counter = dao.deleteStudent(dto);
		
		if(counter ==0) {
			model.addAttribute("err", "delete fail....");
			return "redirect:/studentSearch";
		}else {
			model.addAttribute("msg", "Successfully Deleted....");
			return "redirect:/studentSearch";
		}
		
	}
	
}
