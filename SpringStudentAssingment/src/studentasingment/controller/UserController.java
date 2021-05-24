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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import studentassingment.dao.UserDAO;
import studentassingment.dto.UserDTO;
import studentmanagement.model.UserBean;

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
			
			UserDTO dto = new UserDTO();
			UserDTO udto = new UserDTO();
			udto.setUserId(user.getUserId());
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			dto.setPassword(user.getPassword());
			List<UserDTO> ulist = userDAO.selectUser(udto);
			if (ulist.size() != 0) {
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
	
	@RequestMapping(value="/userSearch",method={RequestMethod.GET, RequestMethod.PUT})
	public String searchUser(@ModelAttribute("uSearch") UserBean bean,ModelMap model) {
		
		
		UserDTO dto = new UserDTO();
		dto.setUserId(bean.getUserId());
		dto.setUserName(bean.getUserName());
		
		List<UserDTO> usrList = userDAO.selectUser(dto);
		
		if(usrList.size() ==0)
			model.addAttribute("msg", "User not found");
		else
			model.addAttribute("userlist", usrList);
		
		
		return "USR001";
	}
	
	@RequestMapping(value="/userDelete/{userId}",method = RequestMethod.GET)
	public String deleteUser(@PathVariable("userId")String userId,ModelMap model) {
		
		UserDTO dto = new UserDTO();
		UserDAO dao = new UserDAO();
		dto.setUserId(userId);
		int counter = dao.deleteUser(dto);
		
		if(counter ==0) {
			model.addAttribute("err", "delee fail....");
			return "redirect:/usermanagement";
		}else {
			model.addAttribute("msg", "Successfully Deleted....");
			return "redirect:/usermanagement";
		}
		
	}
	
	
	
	
	@RequestMapping(value = "/setupUpdateUser/{userId}",method = RequestMethod.GET)
	public ModelAndView setupUpdateBook(@PathVariable String userId) {
		UserDTO dto = new UserDTO(); 
		UserDAO dao = new UserDAO();
		dto.setUserId(userId);
		List<UserDTO> usrList = dao.selectUser(dto);
		UserBean user = new UserBean();
		for(UserDTO u:usrList) {
			user.setUserId(u.getUserId());
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
			UserDAO dao = new UserDAO();
			UserDTO dto = new UserDTO();
			
			
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			dto.setPassword(user.getPassword());
			
			
		
				
				int rs = dao.updateUser(dto);

				if (rs == 0) {
					model.addAttribute("msg", "Update failed");
					return "redirect:/usermanagement";
				} else {
					model.addAttribute("msg", "update Successful");
					return "redirect:/usermanagement";

				}
			}else {
				
			
				model.addAttribute("err", "Password must same");
				return "redirect:/usermanagement";
		
		}	

	}
}
