package com.swp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.dto.DeliveryDTO;
import com.swp.entity.Delivery;
import com.swp.exception.DeliveryNotFoundException;
import com.swp.mapper.DeliveryMapper;
import com.swp.repository.DeliveryRepository;
import com.swp.service.DeliveryService;
@Service
public class DeliveryServiceImplement implements DeliveryService {
	@Autowired
	private DeliveryRepository repo;
	
	public DeliveryServiceImplement(DeliveryRepository repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public List<DeliveryDTO> getAllDelivery() {
		List<Delivery> deliveries = repo.findAll();
		return deliveries.stream().map((delivery) -> DeliveryMapper.mapToDeliveryDTO(delivery)).collect(Collectors.toList());
	}

	@Override
	public DeliveryDTO getDeliveryById(String deliveryId) {
		Delivery deli = repo.findById(deliveryId)
				.orElseThrow(() -> new DeliveryNotFoundException("Delivery with the ID "+deliveryId+" does not exist"));
		return DeliveryMapper.mapToDeliveryDTO(deli);
	}

	@Override
	public DeliveryDTO getDeliveryByOrderId(String orderId) {
		Delivery deli = repo.findDeliveryWithOrderID(orderId);
		return DeliveryMapper.mapToDeliveryDTO(deli);
	}

	@Override
	public List<DeliveryDTO> getDeliveryByAccountId(String accountId) {
		List<Delivery> deli = repo.findDeliveryWithAccountID(accountId);
		return deli.stream().map((delivery) -> DeliveryMapper.mapToDeliveryDTO(delivery)).collect(Collectors.toList());
	}

	@Override
	public List<DeliveryDTO> getDeliveryByStatus(int statusId) {
		List<Delivery> deli = repo.findDeliveryWithStatusID(statusId);
		return deli.stream().map((delivery) -> DeliveryMapper.mapToDeliveryDTO(delivery)).collect(Collectors.toList());
	}

	@Override
	public DeliveryDTO addDelivery(DeliveryDTO dto) {
		Delivery deli = DeliveryMapper.mapToDelivery(dto);
		Delivery saved = repo.save(deli);
		return DeliveryMapper.mapToDeliveryDTO(saved);
	}

	@Override
	public Delivery updateDelivery(String deliveryId, Delivery deli) {
		Delivery needUpdate = repo.findById(deliveryId)
				.orElseThrow(() -> new DeliveryNotFoundException("Delivery with the ID "+deliveryId+" does not exist"));
		needUpdate.setAddress(deli.getAddress());
		needUpdate.setStatusId(deli.getStatusId());
		Delivery updated = repo.save(needUpdate);
		return updated;
	}

	@Override
	public void removeDelivery(String deliveryId) {
		Delivery needReomve = repo.findById(deliveryId)
				.orElseThrow(() -> new DeliveryNotFoundException("Delivery with the ID "+deliveryId+" does not exist"));
		repo.delete(needReomve);
	}

}
