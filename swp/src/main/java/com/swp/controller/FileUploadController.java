package com.swp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.swp.service.CloudinaryService;

import java.io.IOException;
import java.util.Map;

@RestController
public class FileUploadController {

	@Autowired
	private CloudinaryService cloudinaryService;

	@PostMapping("/upload")
	public ResponseEntity<Map> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			Map uploadResult = cloudinaryService.uploadFile(file);
			return new ResponseEntity<>(uploadResult, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
