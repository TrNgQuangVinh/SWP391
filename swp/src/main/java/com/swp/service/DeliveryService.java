package com.swp.service;

import java.util.List;

import com.swp.dto.DeliveryDTO;
import com.swp.entity.Delivery;

public interface DeliveryService {
	List<DeliveryDTO> getAllDelivery();
	DeliveryDTO getDeliveryById(String deliveryId);
	DeliveryDTO getDeliveryByOrderId(String orderId);
	List<DeliveryDTO> getDeliveryByAccountId(String accountId);
	List<DeliveryDTO> getDeliveryByStatus(int statusId);
	DeliveryDTO addDelivery(DeliveryDTO dto);
	Delivery updateDelivery(String deliveryId, Delivery deli);
	void removeDelivery(String deliveryId);
}
