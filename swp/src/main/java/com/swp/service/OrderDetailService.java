package com.swp.service;

import java.util.List;

import com.swp.dto.OrderDetailDTO;
import com.swp.entity.Order_Detail;

public interface OrderDetailService {
	List<OrderDetailDTO> getAllOrderDetail();
	List<OrderDetailDTO> getOrdersByOrderId(String ordersId);
	List<OrderDetailDTO> getOrdersbyProductsId(String productsId);
	OrderDetailDTO getOrderDetailbyBoth(String ordersId, String productsId);
	OrderDetailDTO addOrderDetail(OrderDetailDTO dto);
	Order_Detail updateOrderDetail(String ordersId, String productsId,Order_Detail detail);
}
