package com.swp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/test")
public class TestController {
	@PostMapping("/test-request")
	 public ResponseEntity<String> testPostRequest() {
	    return ResponseEntity.ok("POST request successful");
	}
	
}
