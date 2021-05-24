package com.mfi;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.mfi.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class MFISecurity extends WebSecurityConfigurerAdapter {

	
	 
	 
	@Autowired
	private DataSource dataSource;
	
	/*
	 * @Bean public static NoOpPasswordEncoder passwordEncoder() { return
	 * (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance(); }
	 */
	
	
	  @Bean public PasswordEncoder passwordEncoder() { return new
	  BCryptPasswordEncoder(); }
	 
	 
	@Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
	
	/*
	 * @Bean public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
	 * List<UserDetails> userDetailsList = new ArrayList<>(); userDetailsList.add(
	 * org.springframework.security.core.userdetails.User.withUsername(
	 * "master@gmail.com") .password("admin") .roles("MASTER").build());
	 * 
	 * return new InMemoryUserDetailsManager(userDetailsList);
	 * 
	 * }
	 */
	 @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	       authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	    }
	 

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("master@gmail.com").password("1").roles("REPORTS","LOAN","CRM");
		 		 
		auth.authenticationProvider(authenticationProvider());
		
		
	}
		
		
		
	
		
	 
	
	

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/**").hasAnyRole("CHECKER","MAKER")
			.and()
			.formLogin()
			.loginPage("/login")
			.failureUrl("/login?error=true")
			.defaultSuccessUrl("/checker")
		
		  .and() .logout() .logoutSuccessUrl("/login") .deleteCookies("JSESSIONID")
		 
			;
	}

}
