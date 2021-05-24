package com.studentmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.studentmanagement.dao.ClassService;
import com.studentmanagement.dto.ClassDTO;

import com.studentmanagement.model.ClassBean;


@Controller
public class ClassController {

	@Autowired
	ClassService classService; 
	
	@RequestMapping(value = "/classmanagement",method = RequestMethod.GET)
	public ModelAndView classmanagement() {
		return new ModelAndView("BUD003","classBean",new ClassBean());
	}
	
	

	@RequestMapping(value = "/addClass", method = RequestMethod.POST)
	public String addClass(@ModelAttribute("classBean") @Validated ClassBean classBean, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "BUD003";
		}

		
		
			
			ClassDTO dto = new ClassDTO();
			ClassDTO cdto = new ClassDTO();
			cdto.setClassId(classBean.getClassId());
			dto.setClassId(classBean.getClassId());
			dto.setClassName(classBean.getClassName());
			
			List<ClassDTO> cList = classService.findById(cdto.getClassId());
			
			if (cList.size()!=0) {
				model.addAttribute("err", "Duplicate class id  ");
				return "BUD003";
			} else {

				 classService.insertClass(dto);

					model.addAttribute("msg", "Insert Successful");
					return "BUD003";

				}
			}

		
}
