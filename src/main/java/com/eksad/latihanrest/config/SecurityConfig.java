package com.eksad.latihanrest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eksad.latihanrest.service.UsersService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsersService usersService ;
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.httpBasic().and()
		.csrf().disable() 
		.authorizeRequests() 
		.antMatchers("/admin/**").hasAuthority("ADMIN") 
		.antMatchers("/user/**").hasAnyAuthority("ADMIN", "USER")  
		;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usersService).passwordEncoder(encoder());
	}
	@Bean
 	public BCryptPasswordEncoder encoder() { // merubah password ke bahasa hash. jd ga nampiling String password nya
// 		System.out.println(new BCryptPasswordEncoder().encode("lupa"));
 		
 		return new BCryptPasswordEncoder();
	
	}
}
