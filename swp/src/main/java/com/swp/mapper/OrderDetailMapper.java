package com.swp.mapper;

import com.swp.dto.OrderDetailDTO;
import com.swp.entity.Order_Detail;

public class OrderDetailMapper {
	public static OrderDetailDTO mapToOrderDetailDTO(Order_Detail od) {
		return new OrderDetailDTO(
				od.getOrdersId(),
				od.getProductsId(),
				od.getProductsSize(),
				od.getQuantity(),
				od.getPrice()
				);
	}
	
	public static Order_Detail mapToOrderDetail(OrderDetailDTO dto) {
		return new Order_Detail(
				dto.getOrdersId(),
				dto.getProductsId(),
				dto.getProductsSize(),
				dto.getQuantity(),
				dto.getPrice()
				);
	}
}
