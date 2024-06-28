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

import com.swp.dto.CartDTO;
import com.swp.entity.Cart;
import com.swp.service.CartService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/carts")
public class CartController {
	@Autowired
	private CartService service;

	public CartController(CartService service) {
		super();
		this.service = service;
	}

	@GetMapping("/all")
	public ResponseEntity<List<CartDTO>> getAllCart() {
		return ResponseEntity.ok(service.getAllCart());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<CartDTO> getCartById(@PathVariable("id") String id) {
		return ResponseEntity.ok(service.getCartById(id));
	}

	@PostMapping("/add")
	public ResponseEntity<CartDTO> addCart(@RequestBody CartDTO dto) {
		CartDTO saved = service.addCart(dto);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Cart> updateCart(@PathVariable("id") String id, @RequestBody Cart cart) {
		Cart updated = service.updateCart(id, cart);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCart(@PathVariable("id") String id) {
		service.deleteCart(id);
		return ResponseEntity.ok("Cart with this id " + id + " has been deleted");
	}
}
