package com.mfi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mfi.model.Permission;
import com.mfi.model.User;
import com.mfi.service.MyUserDetails;
import com.mfi.service.PermissionService;
import com.mfi.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private PermissionService perService;
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login() {
		return "user/MFI_LGN_01";
	}

	@RequestMapping("/loginError")
	public String loginError(Model model) {
		model.addAttribute("err", "Error");
		return "mfi/MFI_LGN_01";
	}

	@RequestMapping("/index")
	public String index() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUserDetails currentPrincipalName = (MyUserDetails) authentication.getPrincipal();
		int id = currentPrincipalName.getUserId();
		System.out.println("id:" + currentPrincipalName.getUserId());

		User user = userService.selectOne(id);
		for (Permission p : user.getPermission()) {
			System.out.println(p.getPerName());
		}

		if (user.getRole().getRolePosition().equals("Checker")) {
			System.out.println("role : " + user.getRole().getRoleName());
			return "mfi/checker/checker_dashboard";
		} else {
			System.out.println("role : " + user.getRole().getRoleName());
			return "mfi/maker/maker_dashboard";

		}

	}

	@RequestMapping("/crPer")
	public void createPermission() {
		Permission permission8 = new Permission();
		permission8.setPerName("MAKER");
		Permission permission9 = new Permission();
		permission9.setPerName("CHECKER");

		Permission permission1 = new Permission();
		permission1.setPerName("CRM");
		Permission permission2 = new Permission();
		permission2.setPerName("Account");
		Permission permission3 = new Permission();
		permission3.setPerName("Repots");
		Permission permission4 = new Permission();
		permission4.setPerName("Loan");
		Permission permission5 = new Permission();
		permission5.setPerName("Transaction");
		Permission permission6 = new Permission();
		permission6.setPerName("COA");
		Permission permission7 = new Permission();
		permission7.setPerName("Balcklist");

		perService.createPermission(permission8);
		perService.createPermission(permission1);

		perService.createPermission(permission2);
		perService.createPermission(permission3);
		perService.createPermission(permission4);
		perService.createPermission(permission5);
		perService.createPermission(permission6);
		perService.createPermission(permission7);
		perService.createPermission(permission9);
		

	}
}
