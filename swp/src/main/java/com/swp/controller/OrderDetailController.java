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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swp.dto.OrderDetailDTO;
import com.swp.entity.Order_Detail;
import com.swp.service.OrderDetailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders/details")
public class OrderDetailController {
	@Autowired
	private OrderDetailService service;
	@GetMapping("/all")
	public ResponseEntity<List<OrderDetailDTO>> getAllOrderDetail(){
		return ResponseEntity.ok(service.getAllOrderDetail());
	}
	@GetMapping("/get/order/{id}")
	public ResponseEntity<List<OrderDetailDTO>> getOrderDetails(@PathVariable("id")String id){
		return ResponseEntity.ok(service.getOrdersByOrderId(id));
	}
	@GetMapping("/get/order")
	public ResponseEntity<OrderDetailDTO> getAnOrderDetail(@RequestParam String ordersId,@RequestParam String prodId){
		return ResponseEntity.ok(service.getOrderDetailbyBoth(ordersId, prodId));
	}
	@PostMapping
	public ResponseEntity<OrderDetailDTO> addOrderDetail(@RequestBody OrderDetailDTO dto){
		OrderDetailDTO newDetail = service.addOrderDetail(dto);
		return new ResponseEntity<>(newDetail,HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<Order_Detail> updateDetail(@RequestParam String ordersId,@RequestParam String prodId,@RequestBody Order_Detail detail){
		Order_Detail needUpdate = service.updateOrderDetail(ordersId, prodId, detail);
		return ResponseEntity.ok(needUpdate);
	}
}
