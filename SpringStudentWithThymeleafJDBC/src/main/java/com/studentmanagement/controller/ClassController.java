package com.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.studentmanagement.dao.ClassDAO;
import com.studentmanagement.dto.ClassRequestDTO;
import com.studentmanagement.dto.ClassResponseDTO;
import com.studentmanagement.model.ClassBean;


@Controller
public class ClassController {

	@Autowired
	ClassDAO classDAO = new ClassDAO();
	
	@RequestMapping(value = "/classmanagement",method = RequestMethod.GET)
	public ModelAndView classmanagement() {
		return new ModelAndView("BUD003","classBean",new ClassBean());
	}
	
	

	@RequestMapping(value = "/addClass", method = RequestMethod.POST)
	public String addClass(@ModelAttribute("classBean") @Validated ClassBean classBean, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "BUD003";
		}

		
		
			
			ClassRequestDTO dto = new ClassRequestDTO();
			ClassRequestDTO cdto = new ClassRequestDTO();
			cdto.setClassId(classBean.getClassId());
			dto.setClassId(classBean.getClassId());
			dto.setClassName(classBean.getClassName());
			
			List<ClassResponseDTO> cList = classDAO.selectClass(cdto);
			
			if (cList.size() != 0) {
				model.addAttribute("err", "Duplicate class id  ");
				return "BUD003";
			} else {

				int rs = classDAO.insertClass(dto);

				if (rs == 0) {
					model.addAttribute("err", "Insertion failed");
					return "BUD003";
				} else {
					model.addAttribute("msg", "Insert Successful");
					return "BUD003";

				}
			}

		} 
}
