package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHomePage() {
		
		return "HomePage"; 
	}

	@GetMapping("/leaders")
	public String showLeaders() {
		
		return "leaders";
	}

	@GetMapping("/admin")
	public String showAdmin() {
		
		return "admin";
	}

	//request mapping for "access denied" i.e(403-forbidden)
	@GetMapping("/access-denied")
	public String accessDenied() {
		
		return "access-denied";
	}
}
