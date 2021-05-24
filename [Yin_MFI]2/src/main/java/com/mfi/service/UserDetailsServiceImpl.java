package com.mfi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mfi.model.Permission;
import com.mfi.model.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByEmail(username);
		System.out.println("pass" + user.getPassword());
		System.out.println("enable" + user.getEnabled());
		
		user.getPermission();
		if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
            
        }
		
		return new MyUserDetails(user);
	}
}
