package com.swp.mapper;

import com.swp.dto.DeliveryDTO;
import com.swp.entity.Delivery;

public class DeliveryMapper {
	public static Delivery mapToDelivery(DeliveryDTO dto) {
		return new Delivery(
				dto.getDeliveryId(),
				dto.getOrderId(),
				dto.getAccountId(),
				dto.getAddress(),
				dto.getStatusId()
				); 
	}
	
	public static DeliveryDTO mapToDeliveryDTO(Delivery deli) {
		return new DeliveryDTO(
				deli.getDeliveryId(),
				deli.getOrderId(),
				deli.getAccountId(),
				deli.getAddress(),
				deli.getStatusId()
				);
	}
}
