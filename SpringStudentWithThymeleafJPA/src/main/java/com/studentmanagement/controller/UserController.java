package com.studentmanagement.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.studentmanagement.dao.UserService;
import com.studentmanagement.dto.UserDTO;

import com.studentmanagement.model.UserBean;



@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/usermanagement",method = RequestMethod.GET)
	public ModelAndView usermanagement() {
		return new ModelAndView("USR001","uSearch",new UserBean());
	}
	
	@RequestMapping(value = "/setupAddUser", method = RequestMethod.GET)
	public ModelAndView setupAddUser() {
		return new ModelAndView("USR002", "user", new UserBean());
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") @Validated UserBean user, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "USR002";
		}

		if (user.getPassword().equals(user.getConfirmPass())) {
			
			UserDTO dto = new UserDTO();
			UserDTO udto = new UserDTO();
			udto.setUserId(user.getUserId());
			String id = udto.getUserId();
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			dto.setPassword(user.getPassword());
			
			List<UserDTO> usrlist = userService.findById(id);
			
			if (usrlist.size()!=0) {
				model.addAttribute("err", "Duplicate user id  ");
				return "USR002";
			} else {

				
				userService.insertUser(dto);
				model.addAttribute("msg", "Insert Successful");
				return "USR002";

	
			}

		} else {
			model.addAttribute("err", "Password must be same ");
			return "USR002";
		}

	}
	
	@RequestMapping(value="/userSearch",method= RequestMethod.POST)
	public String searchUser(@ModelAttribute("uSearch") UserBean bean,ModelMap model) {
		
		
		UserDTO dto = new UserDTO();
		dto.setUserId(bean.getUserId());
		dto.setUserName(bean.getUserName());
		List<UserDTO> usrList = new ArrayList<UserDTO>();
		if(!dto.getUserId().equals("")) {
			 usrList =userService.findById(dto.getUserId());
			
			
			;
		}else if(!dto.getUserName().equals("")) {
			usrList =userService.findByName(dto.getUserName());
		}else {
			 usrList = userService.getAllUser();
		}
		
		
		
		if(usrList.size() ==0)
			model.addAttribute("msg", "User not found");
		else
			model.addAttribute("userlist", usrList);
		
		
		return "USR001";
	}
	
	@RequestMapping(value="/userDelete",method = RequestMethod.GET)
	public String deleteUser(@RequestParam("userId")String userId,ModelMap model,RedirectAttributes redirAttrs) {
		
		UserDTO dto = new UserDTO();
		
		dto.setUserId(userId);
		 userService.deleteUser(dto.getUserId());
		
		
			redirAttrs.addFlashAttribute("msg", "Successfully Deleted....");
			return "redirect:/usermanagement";
		
		
	}
	
	
	
	
	@RequestMapping(value = "/setupUpdateUser",method = RequestMethod.GET)
	public ModelAndView setupUpdateUser(@RequestParam("userId") String userId) {
		UserDTO dto = new UserDTO(); 
		
		dto.setUserId(userId);
		
		List<UserDTO> usrList = userService.findById(dto.getUserId());

		UserBean user = new UserBean();
		for(UserDTO u : usrList) {
			user .setUserId(u.getUserId());
			user.setUserName(u.getUserName());
			user.setPassword(u.getPassword());
			user.setConfirmPass(u.getPassword());
		}
			
		
		return new ModelAndView("USR002-01","user",user);
	}
	
	
	@RequestMapping(value = "/updateUser",method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user")@Validated UserBean user, BindingResult result,RedirectAttributes redirectAttributes ) {
		
		if(result.hasErrors()) {
			return "USR002-01";
		}
		if (user.getPassword().equals(user.getConfirmPass())) {
			
			UserDTO dto = new UserDTO();
			
			System.out.println("USer id : " + user.getUserId());
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			dto.setPassword(user.getPassword());
			
			
		
				
				 userService.updateUser(dto,dto.getUserId());
				

				
				
				 redirectAttributes.addFlashAttribute("msg", "update Successful");
					return "redirect:/usermanagement";

				
			}else {
				
			
				redirectAttributes.addFlashAttribute("err", "Password must same");
				return "redirect:/usermanagement";
		
		}	

	}
}
