package com.mfi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/login")
	public String login() {
		return "MFI_LGN_01";
	}
	@RequestMapping("/index")
	public String home() {
		return "index";
	}
}
