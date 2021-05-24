package studentasingment.controller;

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

import studentassingment.dao.ClassDAO;

import studentassingment.dto.ClassDTO;

import studentmanagement.model.ClassBean;


@Controller
public class ClassController {

	@Autowired
	ClassDAO classDAO = new ClassDAO();
	@RequestMapping(value = "/classmanagement",method = RequestMethod.GET)
	public ModelAndView classmanagement() {
		return new ModelAndView("BUD003","classBean",new ClassBean());
	}
	
	

	@RequestMapping(value = "/addClass", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("classBean") @Validated ClassBean classBean, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "BUD003";
		}

		
			
			ClassDTO dto = new ClassDTO();
			ClassDTO cdto = new ClassDTO();
			cdto.setClassId(classBean.getClassId());
			System.out.println("ID"+classBean.getClassId());
			dto.setClassId(classBean.getClassId());
			dto.setClassName(classBean.getClassName());
			
			List<ClassDTO> cList = classDAO.selectOne(cdto);
			System.out.println("size" + cList.size());
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
	
	
	
	
	
	

	
	
	
	

