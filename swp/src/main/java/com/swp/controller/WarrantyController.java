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

import com.swp.dto.WarrantyDTO;
import com.swp.entity.Warranty;
import com.swp.service.WarrantyService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/warranties")
public class WarrantyController {
	
	@Autowired
	private WarrantyService warrantyService;

	public WarrantyController(WarrantyService warrantyService) {
		super();
		this.warrantyService = warrantyService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<WarrantyDTO>> getWarranty(){
		return ResponseEntity.ok(warrantyService.getWarranty());
	}
	
	@GetMapping("/get/account/name/{name}")
	public ResponseEntity<List<WarrantyDTO>> getWarrantyByCustomerName(@PathVariable("name") String name) {
		//Category category = new Category(id, name, null);
		if (name == null || name.trim().isEmpty()) {
			// Return an appropriate response or throw a custom exception
			return ResponseEntity.badRequest().body(null);
		}
		List<WarrantyDTO> warrantys = warrantyService.getWarrantybyCustName(name);
		return ResponseEntity.ok(warrantys);
	}
	
	@GetMapping("/get/account/id/{id}")
	public ResponseEntity<List<WarrantyDTO>> getWarrantyByCustomerID(@PathVariable("id") String id) {
		//Category category = new Category(id, name, null);
		if (id == null || id.trim().isEmpty()) {
			// Return an appropriate response or throw a custom exception
			return ResponseEntity.badRequest().body(null);
		}
		List<WarrantyDTO> warrantys = warrantyService.getWarrantybyCustID(id);
		return ResponseEntity.ok(warrantys);
	}
	
	@GetMapping("/get/product/{name}")
	public ResponseEntity<List<WarrantyDTO>> getWarrantyByProductName(@PathVariable("name") String name) {
		//Category category = new Category(id, name, null);
		if (name == null || name.trim().isEmpty()) {
			// Return an appropriate response or throw a custom exception
			return ResponseEntity.badRequest().body(null);
		}
		List<WarrantyDTO> warrantys = warrantyService.getWarrantybyProductName(name);
		return ResponseEntity.ok(warrantys);
	}
	
	@PostMapping
	public ResponseEntity<WarrantyDTO> createWarranty(@RequestBody WarrantyDTO warrantyDTO) {
		WarrantyDTO savedWarranty = warrantyService.addWarranty(warrantyDTO);
		return new ResponseEntity<>(savedWarranty, HttpStatus.CREATED);
	}
	@PutMapping("{id}")
	public ResponseEntity<Warranty> updateWarranty(@PathVariable("id") String warrantyId, @RequestBody Warranty warranty) {
		Warranty upWarranty = warrantyService.updateWarranty(warrantyId, warranty);
		return ResponseEntity.ok(upWarranty);
	}

	// DeleteUserById
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteWarranty(@PathVariable("id") String warrantyID) {
		warrantyService.deleteWarranty(warrantyID);
		return ResponseEntity.ok("Product of this id " + warrantyID + " has been deleted");
	}

}
