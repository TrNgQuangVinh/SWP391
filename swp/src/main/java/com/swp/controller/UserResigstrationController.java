package com.swp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swp.dto.UserResigstration;
import com.swp.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserResigstrationController {
	private UserService userService;

	public UserResigstrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping
	public String showResigstrationForm() {
		return "resigstration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserResigstration userResigstration) {
		userService.saveResigstration(userResigstration);
		return "redirect/resigstration?success";
	}
}
