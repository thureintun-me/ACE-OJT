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

import com.mfi.model.Customer;
import com.mfi.model.Role;
import com.mfi.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@GetMapping("/roleAdd")
	public String addRole(Model model) {
		model.addAttribute("roleBean",new Role());
		return "user/MFI_ROL_01";
	}
	@PostMapping("/roleregister")
	public String addCrm(@ModelAttribute("roleBean")  Role role, Model model) {
        	System.out.println("role"+role.getRoleName());
        	System.out.println("op"+role.getRolePosition());
			roleService.save(role);
			return "redirect:/role";
		}
	
	@GetMapping("/roleEdit/{id}")
	public String roleEdit(@PathVariable("id")int id,Model model) {
		model.addAttribute("roleEdit", roleService.selectId(id));
		return "user/MFI_ROL_03";
	}
	@PostMapping("/roleEdit/{id}")
	public String customerUpdate(@ModelAttribute("roleEdit") @Valid Role role, BindingResult result, @PathVariable("id")int id,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("roleEdit", role);
			return "user/MFI_CRM_03";
		}
		role.setRoleId(id);
		roleService.update(role);
		return "redirect:/role";
	}
 }

