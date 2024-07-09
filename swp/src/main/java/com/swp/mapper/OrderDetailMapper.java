package com.swp.mapper;

import com.swp.dto.OrderDetailDTO;
import com.swp.entity.OrderDetail;

public class OrderDetailMapper {
	public static OrderDetailDTO mapToOrderDetailDTO(OrderDetail od) {
		return new OrderDetailDTO(
				od.getOrdersId(),
				od.getProductsId(),
				od.getProductsSize(),
				od.getQuantity(),
				od.getPrice()
				);
	}
	
	public static OrderDetail mapToOrderDetail(OrderDetailDTO dto) {
		return new OrderDetail(
				dto.getOrdersId(),
				dto.getProductsId(),
				dto.getProductsSize(),
				dto.getQuantity(),
				dto.getPrice()
				);
	}
}
