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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swp.dto.ProductDTO;
import com.swp.entity.Product;
import com.swp.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductDTO>> getProduct(){
		return ResponseEntity.ok(productService.getProduct());
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") String id) {
		if (id == null || id.trim().isEmpty()) {
			// Return an appropriate response or throw a custom exception
			return ResponseEntity.badRequest().body(null);
		}
		ProductDTO product = productService.getProductbyID(id);
		return ResponseEntity.ok(product);
	}
	@GetMapping("/get")
	public ResponseEntity<ProductDTO> getProductByCategory(@RequestParam String id) {
		//Category category = new Category(id, name, null);
		if (id == null || id.trim().isEmpty()) {
			// Return an appropriate response or throw a custom exception
			return ResponseEntity.badRequest().body(null);
		}
		ProductDTO products = productService.getProductbyCategory(id);
		return ResponseEntity.ok(products);
	}
	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
		ProductDTO savedProd = productService.addProduct(productDTO);
		return new ResponseEntity<>(savedProd, HttpStatus.CREATED);
	}
	@PutMapping("{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") String productId, @RequestBody Product product) {
		Product upProduct = productService.updateProduct(productId, product);
		return ResponseEntity.ok(upProduct);
	}

	// DeleteUserById
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") String productID) {
		productService.deleteProduct(productID);
		return ResponseEntity.ok("Product of this id " + productID + " has been deleted");
	}
}
