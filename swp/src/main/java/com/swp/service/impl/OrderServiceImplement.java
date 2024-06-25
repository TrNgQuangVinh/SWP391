package com.swp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.dto.OrderDTO;
import com.swp.entity.Order;
import com.swp.exception.OrderNotFoundException;
import com.swp.mapper.OrderMapper;
import com.swp.repository.OrderRepository;
import com.swp.service.OrderService;
@Service
public class OrderServiceImplement implements OrderService {
	@Autowired
	private OrderRepository repo;

	public OrderServiceImplement(OrderRepository repository) {
		super();
		this.repo = repository;
	}

	@Override
	public List<OrderDTO> getOrder() {
		List<Order> orders = repo.findAll();
		return orders.stream().map((order) -> OrderMapper.mapToOrderDTO(order)).collect(Collectors.toList());
	}

	@Override
	public OrderDTO getOrderById(String id) {
		Order order = repo.findById(id)
				.orElseThrow(() -> new OrderNotFoundException("Order does not exist with this id:"+id));
		return OrderMapper.mapToOrderDTO(order);
	}

	@Override
	public OrderDTO addOrder(OrderDTO dto) {
		Order order = OrderMapper.mapToOrder(dto);
		Order savedOrder = repo.save(order);
		return OrderMapper.mapToOrderDTO(savedOrder);
	}

	@Override
	public Order updateOrder(String id, Order order) {
		Order findedOrder = repo.findById(id)
				.orElseThrow(() -> new OrderNotFoundException("Order does not exist with this id:"+id));
		findedOrder.setAddress(order.getAddress());
		findedOrder.setProducts(order.getProducts());
		findedOrder.setTotalPrice(order.getTotalPrice());
		findedOrder.setStatusId(order.getStatusId());
		Order updatedOrder = repo.save(findedOrder);
		return updatedOrder;
	}

	@Override
	public void deleteOrder(String id) {
		Order order = repo.findById(id)
				.orElseThrow(() -> new OrderNotFoundException("Order does not exist with this id:"+id));
		repo.delete(order);
	}

}
