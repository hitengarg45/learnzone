package com.amdocs.learnzone.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String homePage() {
		return "Home Page";
	}
	
	@GetMapping("/register")
	public String registerForm() {
		return "Sign Up form";
	}
}
