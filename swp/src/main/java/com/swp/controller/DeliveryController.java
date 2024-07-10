package com.swp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp.dto.DeliveryDTO;
import com.swp.entity.Delivery;
import com.swp.service.DeliveryService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
	@Autowired
	private DeliveryService service;

	public DeliveryController(DeliveryService serv) {
		super();
		this.service = serv;
	}

	@GetMapping("/all")
	public ResponseEntity<List<DeliveryDTO>> getAllDeliveries() {
		return ResponseEntity.ok(service.getAllDelivery());
	}

	@GetMapping("/delivery/{id}")
	public ResponseEntity<DeliveryDTO> getDeliveryById(@PathVariable("id") String deliId) {
		return ResponseEntity.ok(service.getDeliveryById(deliId));
	}

	@GetMapping("/delivery/order/{orderId}")
	public ResponseEntity<DeliveryDTO> getDeliveryByOrderId(@PathVariable("orderId") String deliId) {
		return ResponseEntity.ok(service.getDeliveryByOrderId(deliId));
	}

	@GetMapping("/delivery/account/{id}")
	public ResponseEntity<List<DeliveryDTO>> getDeliveriesByAccount(@PathVariable("id") String accountId) {
		return ResponseEntity.ok(service.getDeliveryByAccountId(accountId));
	}

	@GetMapping("/delivery/status/{id}")
	public ResponseEntity<List<DeliveryDTO>> getDeliveriesByStatus(@PathVariable("id") int statusId) {
		return ResponseEntity.ok(service.getDeliveryByStatus(statusId));
	}
	@PostMapping("/add")
	public ResponseEntity<DeliveryDTO> addDelivery(@RequestBody DeliveryDTO dto){
		DeliveryDTO added = service.addDelivery(dto);
		return new ResponseEntity<>(added,HttpStatus.CREATED);
	}
	@PatchMapping("/update/{id}")
	public ResponseEntity<Delivery> updateDelivery(@PathVariable("id")String deliveryId,@RequestBody Delivery deli){
		Delivery update = service.updateDelivery(deliveryId, deli);
		return ResponseEntity.ok(update);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDelivery(@PathVariable("id")String id) {
		service.removeDelivery(id);
		return ResponseEntity.ok("Delivery with this id " + id + " has been deleted");
	}
}
