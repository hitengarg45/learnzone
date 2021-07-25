package com.amdocs.learnzone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.amdocs.learnzone.models.User;
import com.amdocs.learnzone.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}
	
	@PostMapping("/register/add")
	public String addUser(User user) throws Exception {
		userService.addUser(user);
	    return "register_success";
	}
}
