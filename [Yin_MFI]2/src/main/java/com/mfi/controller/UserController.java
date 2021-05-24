package com.mfi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mfi.formmodel.Userform;
import com.mfi.model.Customer;
import com.mfi.model.Permission;
import com.mfi.model.Role;
import com.mfi.model.User;
import com.mfi.service.PermissionService;
import com.mfi.service.RoleService;
import com.mfi.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	PermissionService permissionService;

	@GetMapping("/setupuserRegister")
	public String setupuserRegister(Model model) {
		List<Role> role = roleService.selectAll();
		model.addAttribute("userBean", new Userform());
		model.addAttribute("role", role);
		model.addAttribute("permission", permissionService.selectAll());
		return "user/MFI_CUR_01";
	}

	@PostMapping("/userRegister")
	public String userRegister(@ModelAttribute("userBean") Userform user, Model model) {

		if (!user.getConPass().equals(user.getPassword())) {
			model.addAttribute("user", user);
			model.addAttribute("role", roleService.selectAll());

//			model.addAttribute("error", "error");
			return "user/MFI_CUR_01";
		}

		Role role = roleService.selectId(user.getRole());
		
			 
		User userBean = new User();
		userBean.setName(user.getName());
		userBean.setEmail(user.getEmail());
		userBean.setNrc(user.getNrc());
		userBean.setPassword(user.getPassword());
		userBean.setPhone(user.getPhone());
		userBean.setRole(role);
		userBean.setPosition(user.getPosition());
		for(int i=0;i<user.getPermission().size();i++) {
			
			Permission p =permissionService.selectById(user.getPermission().get(i));
			userBean.getPermission().add(p);
			userService.save(userBean);
		}
		
		System.out.println(user.getRole());
//		
		
		System.out.println("perName"+user.getPermission());
		return "user/MFI_CUR_02";
	}
	
		
	
	
	

	@RequestMapping("/userSearch")
	public String searchAll(@ModelAttribute("userBean") User user, Model model) {
		List<User> userList = userService.findbyName(user.getName());
		model.addAttribute("userList", userList);
		return "user/MFI_CUR_02";

	}

	@GetMapping("/userEdit/{id}")
	public String userEdit(@PathVariable("id") int id, Model model) {
		List<Role> roleList = roleService.selectAll();
		model.addAttribute("roleList", roleList);

		model.addAttribute("userEdit", userService.selectOne(id));
		return "user/MFI_CUR_03";
	}

	@PostMapping("/userEdit/{id}")
	public String usreUpdate(@ModelAttribute("userEdit") @Valid User user, BindingResult result,
			@PathVariable("id") int id, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "MFI_CUR_03";
		}
		if (!user.getConPass().equals(user.getPassword())) {
			model.addAttribute("user", user);
//			model.addAttribute("error", "error");
			return "user/MFI_CUR_03";
		}

		user.setUser_id(id);
		userService.update(user);
		return "redirect:/user";
	}

}
