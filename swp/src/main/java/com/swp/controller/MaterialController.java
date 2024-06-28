package com.swp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp.dto.MaterialDTO;
import com.swp.entity.Material;
import com.swp.service.MaterialService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/material")
public class MaterialController {
	
	@Autowired
	private MaterialService matService;

	public MaterialController(MaterialService matService) {
		super();
		this.matService = matService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<MaterialDTO>> getMaterial(){
		return ResponseEntity.ok(matService.getMaterial());
	}
	
	@PostMapping
	public ResponseEntity<MaterialDTO> createMaterial(@RequestBody MaterialDTO matDTO) {
		MaterialDTO savedMaterial = matService.addMaterial(matDTO);
		return new ResponseEntity<>(savedMaterial, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Material> updateMaterial(@PathVariable("id") String materialId, @RequestBody Material mat) {
		Material upCate = matService.updateMaterial(materialId, mat);
		return ResponseEntity.ok(upCate);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteMaterial(@PathVariable("id") String matID) {
		matService.deleteMaterial(matID);
		return ResponseEntity.ok("Product of this id " + matID + " has been deleted");
	}

}
