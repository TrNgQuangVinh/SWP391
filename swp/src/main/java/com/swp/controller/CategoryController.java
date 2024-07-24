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

import com.swp.dto.CategoryDTO;
import com.swp.entity.Category;
import com.swp.service.CategoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService cateService;
	
	public CategoryController(CategoryService cateService) {
		super();
		this.cateService = cateService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CategoryDTO>> getCategory(){
		return ResponseEntity.ok(cateService.getCategory());
	}
	
	@PostMapping
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO cateDTO) {
		CategoryDTO savedCategory = cateService.addCategory(cateDTO);
		return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") String categoryId, @RequestBody Category cate) {
		Category upCate = cateService.updateCategory(categoryId, cate);
		return ResponseEntity.ok(upCate);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") String cateID) {
		cateService.deleteCategory(cateID);
		return ResponseEntity.ok("Product of this id " + cateID + " has been deleted");
	}
}
