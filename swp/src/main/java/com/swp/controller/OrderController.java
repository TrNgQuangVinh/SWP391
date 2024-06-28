package com.swp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.swp.dto.OrderDTO;
import com.swp.entity.Order;
import com.swp.service.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	private OrderService service;
	@GetMapping("/all")
	public ResponseEntity<List<OrderDTO>> getAllOrder(){
		return ResponseEntity.ok(service.getOrder());
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable("id")String id){
		return ResponseEntity.ok(service.getOrderById(id));
	}
	@PostMapping
	public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO dto){
		OrderDTO savedDTO = service.addOrder(dto);
		return new ResponseEntity<>(savedDTO, HttpStatus.CREATED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable("id")String id,@RequestBody Order order){
		Order updateOrder = service.updateOrder(id, order);
		return ResponseEntity.ok(updateOrder);
	}
}
