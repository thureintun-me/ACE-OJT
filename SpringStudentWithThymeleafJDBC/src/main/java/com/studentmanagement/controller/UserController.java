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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studentmanagement.dao.UserDAO;
import com.studentmanagement.dto.UserRequestDTO;
import com.studentmanagement.dto.UserResponseDTO;
import com.studentmanagement.model.UserBean;



@Controller
public class UserController {

	@Autowired
	UserDAO userDAO = new UserDAO();
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
			
			UserRequestDTO dto = new UserRequestDTO();
			UserRequestDTO udto = new UserRequestDTO();
			udto.setUserId(user.getUserId());
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			dto.setPassword(user.getPassword());
			
			List<UserResponseDTO> usrlist = userDAO.selectUser(udto);
			
			if (usrlist.size() != 0) {
				model.addAttribute("err", "Duplicate user id  ");
				return "USR002";
			} else {

				int rs = userDAO.insertUser(dto);
				
				if (rs == 0) {
					model.addAttribute("err", "Insertion failed");
					return "USR002";
				} else {
					
					model.addAttribute("msg", "Insert Successful");
					return "USR002";

				}
			}

		} else {
			model.addAttribute("err", "Password must be same ");
			return "USR002";
		}

	}
	
	@RequestMapping(value="/userSearch",method= RequestMethod.POST)
	public String searchUser(@ModelAttribute("uSearch") UserBean bean,ModelMap model) {
		
		
		UserRequestDTO dto = new UserRequestDTO();
		dto.setUserId(bean.getUserId());
		dto.setUserName(bean.getUserName());
		
		List<UserResponseDTO> usrList = userDAO.selectUser(dto);
		
		if(usrList.size() ==0)
			model.addAttribute("msg", "User not found");
		else
			model.addAttribute("userlist", usrList);
		
		
		return "USR001";
	}
	
	@RequestMapping(value="/userDelete",method = RequestMethod.GET)
	public String deleteUser(@RequestParam("userId")String userId,ModelMap model,RedirectAttributes redirAttrs) {
		
		UserRequestDTO dto = new UserRequestDTO();
		
		dto.setUserId(userId);
		int counter = userDAO.deleteUser(dto);
		
		if(counter ==0) {
			redirAttrs.addFlashAttribute("err", "delee fail....");
			return "redirect:/usermanagement";
		}else {
			redirAttrs.addFlashAttribute("msg", "Successfully Deleted....");
			return "redirect:/usermanagement";
		}
		
	}
	
	
	
	
	@RequestMapping(value = "/setupUpdateUser",method = RequestMethod.GET)
	public ModelAndView setupUpdateBook(@RequestParam("userId") String userId) {
		UserRequestDTO dto = new UserRequestDTO(); 
		;
		dto.setUserId(userId);
		System.out.println("userId"+userId);
		List<UserResponseDTO> usrList = userDAO.selectUser(dto);
		UserBean user = new UserBean();
		for(UserResponseDTO u:usrList) {
			user .setUserId(u.getUserId());
			user.setUserName(u.getUserName());
			user.setPassword(u.getPassword());
			user.setConfirmPass(u.getPassword());
		}
		return new ModelAndView("USR002-01","user",user);
	}
	
	
	@RequestMapping(value = "/updateUser",method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user")@Validated UserBean user, BindingResult result,ModelMap model ) {
		
		if(result.hasErrors()) {
			return "addbook";
		}
		if (user.getPassword().equals(user.getConfirmPass())) {
			
			UserRequestDTO dto = new UserRequestDTO();
			
			System.out.println("USer id : " + user.getUserId());
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			dto.setPassword(user.getPassword());
			
			
		
				
				int rs = userDAO.updateUser(dto);
				System.out.println(rs);

				if (rs == 0) {
					model.addAttribute("msg", "Update failed");
					return "USR002-01";
				} else {
					model.addAttribute("msg", "update Successful");
					return "USR002-01";

				}
			}else {
				
			
				model.addAttribute("err", "Password must same");
				return "redirect:/usermanagement";
		
		}	

	}
}
