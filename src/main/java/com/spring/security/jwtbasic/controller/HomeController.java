package com.spring.security.jwtbasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/home")
	public String welcomeToHome() {
		return "Welcome To Home";
	}

}
