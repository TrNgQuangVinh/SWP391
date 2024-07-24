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

import com.swp.dto.DiamondDTO;
import com.swp.entity.Diamond;
import com.swp.service.DiamondService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/diamonds")
public class DiamondController {
	@Autowired
	private DiamondService diamondService;

	public DiamondController(DiamondService diamondService) {
		super();
		this.diamondService = diamondService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<DiamondDTO>> getDiamonds(){
		return ResponseEntity.ok(diamondService.getDiamond());
	}
	@PostMapping
	public ResponseEntity<DiamondDTO> createDiamond(@RequestBody DiamondDTO diamondDTO){
		DiamondDTO savedDiamond = diamondService.addDiamond(diamondDTO);
		return new ResponseEntity<>(savedDiamond,HttpStatus.CREATED);
	}
	@PutMapping("{id}")
	public ResponseEntity<DiamondDTO> updateProduct(@PathVariable("id") int diamondID, @RequestBody Diamond diamond) {
		DiamondDTO upDiamond = diamondService.updateDiamond(diamondID, diamond);
		return ResponseEntity.ok(upDiamond);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int diamondID) {
		diamondService.deleteDiamond(diamondID);
		return ResponseEntity.ok("Diamond of this id " + diamondID + " has been deleted");
	}
}
