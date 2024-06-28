package com.swp.service;

import java.util.List;

import com.swp.dto.OrderDTO;
import com.swp.entity.Order;

public interface OrderService {
	List<OrderDTO> getOrder();
	OrderDTO getOrderById(String id);
	OrderDTO addOrder(OrderDTO dto);
	Order updateOrder(String id, Order order);
	void deleteOrder(String id);
}
