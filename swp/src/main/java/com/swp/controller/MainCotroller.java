package com.swp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class MainCotroller {
	@GetMapping("/signin")
	public String login() {
		return "login";
	}
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
