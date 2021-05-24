package com.studentmanagement.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.studentmanagement.dao.ClassService;
import com.studentmanagement.dao.UserService;
import com.studentmanagement.dto.ClassDTO;

import com.studentmanagement.dto.UserDTO;
import com.studentmanagement.model.UserBean;



@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@Autowired
	ClassService classService;
	
	@RequestMapping("/")
	public ModelAndView setupLogin() {
		return new ModelAndView("LGN001","login",new UserBean());
	}
	
	
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@ModelAttribute("login")UserBean bean,HttpSession session,ModelMap model) {
		
		
		if(bean.getUserId().equals("") || bean.getPassword().equals("")) {
			model.addAttribute("err", "Feilds must not be null");
			return "LGN001";
		}else {
			UserDTO dto=new UserDTO();
			dto.setUserId(bean.getUserId());
			List<UserDTO> list = userService.findById(dto.getUserId());
			if (list.size()==0) {
				model.addAttribute("err", "User not found!");
				return "LGN001";
			}else if (bean.getPassword().equals(list.get(0).getPassword())) {
				session.setAttribute("sesUser", list.get(0));
				session.setAttribute("date", new Date());
			
				return "M00001";
			} else {
				model.addAttribute("err", "Password is incorrect!");
				return "LGN001";
			}
	}

}
	
	@RequestMapping(value="/logout" ,method=RequestMethod.POST)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/";
	}
}
