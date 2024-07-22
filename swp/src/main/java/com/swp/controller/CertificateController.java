package com.swp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp.dto.CertificateDTO;
import com.swp.entity.Certificate;
import com.swp.service.CertificateService;

import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/certificates")
public class CertificateController {
	@Autowired
	private CertificateService service;
	
	public CertificateController(CertificateService service) {
		super();
		this.service = service;
	}
	@GetMapping("/all")
	public ResponseEntity<List<CertificateDTO>> getAllCertificates() {
		return ResponseEntity.ok(service.getAllCertificate());
	}
	@GetMapping("/{id}")
	public ResponseEntity<CertificateDTO> getCertificateById(@PathVariable("id")String Id){
		return ResponseEntity.ok(service.getCertificateById(Id));
	}
	@GetMapping("/diamond/{id}")
	public ResponseEntity<CertificateDTO> getCertificateByDiamondId(@PathVariable("id")int Id){
		return ResponseEntity.ok(service.getCertificateByDiamondId(Id));
	}
	@PostMapping
	public ResponseEntity<CertificateDTO> addCertificate(@RequestBody CertificateDTO dto){
		CertificateDTO saved = service.addCertificate(dto);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	@PatchMapping("/{id}")
	public ResponseEntity<Certificate> updateCertificate(@PathVariable("id")String Id,@RequestBody Certificate cert){
		Certificate uped = service.updateCertificate(Id, cert);
		return ResponseEntity.ok(uped);
	}
}
