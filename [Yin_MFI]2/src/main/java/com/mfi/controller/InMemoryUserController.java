package com.mfi.controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class InMemoryUserController {

	/*
	 * private final InMemoryUserDetailsManager inMemoryUserDetailsManager;
	 * 
	 * public UserController(InMemoryUserDetailsManager inMemoryUserDetailsManager)
	 * { this.inMemoryUserDetailsManager = inMemoryUserDetailsManager; }
	 * 
	 * @PostMapping("/register") public String register(@RequestParam("username")
	 * String username, @RequestParam("password") String password) {
	 * inMemoryUserDetailsManager.createUser(org.springframework.security.core.
	 * userdetails.User.withUsername(username).password("{noop}" +
	 * password).roles("USER").build()); return username + " Created!"; }
	 */
	
}
