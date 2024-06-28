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

import com.swp.dto.CartProductDTO;
import com.swp.entity.CartProduct;
import com.swp.service.CartProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/carts/product")
public class CartProductController {
	@Autowired
	private CartProductService ser;

	public CartProductController(CartProductService service) {
		super();
		this.ser = service;
	}

	@GetMapping("/all")
	public ResponseEntity<List<CartProductDTO>> getAllCartProducts() {
		return ResponseEntity.ok(ser.getAllCartDetail());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<List<CartProductDTO>> getACartProducts(@PathVariable("id") String id) {
		return ResponseEntity.ok(ser.getCartById(id));
	}

	@GetMapping("/get/cart")
	public ResponseEntity<CartProductDTO> getACartProduct(@RequestParam String cartId, @RequestParam String prodId) {
		return ResponseEntity.ok(ser.getCartByBothId(cartId, prodId));
	}

	@PostMapping("/add")
	public ResponseEntity<CartProductDTO> addCartProduct(@RequestBody CartProductDTO dto) {
		CartProductDTO newProd = ser.addCartProd(dto);
		return new ResponseEntity<>(newProd, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<CartProduct> updateCartProduct(@RequestParam String cartId, @RequestParam String prodId, 
			@RequestBody CartProduct cart){
		CartProduct updated = ser.updateCartProd(cartId, prodId, cart);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteACartProd(@RequestParam String cartId, @RequestParam String prodId){
		ser.removeCartProduct(cartId, prodId);
		return ResponseEntity.ok("Cart's product with this id "+prodId+" has been delete");
	}
}
