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

import com.swp.dto.ProductDTO;
import com.swp.dto.ShellDTO;
import com.swp.entity.Product;
import com.swp.entity.Shell;
import com.swp.service.ShellService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/shells")
public class ShellController {
	
	@Autowired
	private ShellService shellService;

	public ShellController(ShellService shellService) {
		super();
		this.shellService = shellService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ShellDTO>> getShell(){
		return ResponseEntity.ok(shellService.getShell());
	}
	
	@GetMapping("/get/category/{id}")
	public ResponseEntity<List<ShellDTO>> getProductByMaterial(@PathVariable("id") String id) {
		//Category category = new Category(id, name, null);
		if (id == null || id.trim().isEmpty()) {
			// Return an appropriate response or throw a custom exception
			return ResponseEntity.badRequest().body(null);
		}
		List<ShellDTO> shells = shellService.getShellbyCategory(id);
		return ResponseEntity.ok(shells);
	}
	
	@PostMapping
	public ResponseEntity<ShellDTO> createShell(@RequestBody ShellDTO shellDTO) {
		ShellDTO savedShell = shellService.addShell(shellDTO);
		return new ResponseEntity<>(savedShell, HttpStatus.CREATED);
	}
	@PutMapping("{id}")
	public ResponseEntity<Shell> updateShell(@PathVariable("id") String shellId, @RequestBody Shell shell) {
		Shell upShell = shellService.updateShell(shellId, shell);
		return ResponseEntity.ok(upShell);
	}

	// DeleteUserById
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteShell(@PathVariable("id") String shellID) {
		shellService.deleteShell(shellID);
		return ResponseEntity.ok("Product of this id " + shellID + " has been deleted");
	}

}
