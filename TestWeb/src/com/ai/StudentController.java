package com.ai;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	@RequestMapping(value = "/addStudent",method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("addStudent","command",new Student());
	}
	
	@ModelAttribute("stu")
	public Student createStudentModel() {
		return new Student();
	}
	
	@RequestMapping(value = "/addStudent",method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("stu")@Validated Student student,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "addStudent";
		}
		model.addAttribute("name", student.getName());
		model.addAttribute("age", student.getAge());
		model.addAttribute("id", student.getId());
		return "result";
	}
}
