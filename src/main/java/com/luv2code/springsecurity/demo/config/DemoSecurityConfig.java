package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	//inject dataSource dependency 
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {	
		
		//use jdbc authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	//if this formLogin() code is not written then default Spring-security login page will be open
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()							//Restrict access based on the HttpServletRequest coming in
//			.anyRequest().authenticated()					//any request coming to the app must be authenticated (i.e user must be logged in)
		.antMatchers("/").hasRole("EMPLOYEE")				//restric access based on role (thats why we comment out above line)
		.antMatchers("/leaders/**").hasRole("Manager")
		.antMatchers("/admin/**").hasRole("ADMIN")			//spring security will append  'ROLE_' to role/authority attribute(thats why in DB ROLE_ADMIN )
		.and()
		.formLogin()										//we are customizing the form login process
			.loginPage("/showMyLoginPage")					//show our custom form at given request mapping										 }any name
			.loginProcessingUrl("/authenticateTheUser")		//login form should POST data to this URL for processing (check userId and password) }any name
			.permitAll()
		.and()
		.logout().permitAll()									//allow everyone to see login page
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");	//it is used when there is authorization error or user cannot access the current page
		
	}

	
	
}
