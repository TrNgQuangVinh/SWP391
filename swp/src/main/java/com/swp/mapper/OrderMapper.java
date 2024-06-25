package com.swp.mapper;

import com.swp.dto.OrderDTO;
import com.swp.entity.Order;

public class OrderMapper {
	public static OrderDTO mapToOrderDTO(Order order) {
		return new OrderDTO(
				order.getOrderId(),
				order.getAccountId(),
				order.getTotalPrice(),
				order.getAddress(),
				order.getStatusId(),
				order.getProducts()
				);
	}
	
	public static Order mapToOrder(OrderDTO odDTO) {
		return new Order(
				odDTO.getOrderId(),
				odDTO.getAccountId(),
				odDTO.getTotalPrice(),
				odDTO.getAddress(),
				odDTO.getStatusId(),
				odDTO.getProducts()
				);
	}
}
