package com.swp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.dto.OrderDetailDTO;
import com.swp.entity.Order_Detail;
import com.swp.mapper.OrderDetailMapper;
import com.swp.repository.OrderDetailRepository;
import com.swp.service.OrderDetailService;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	private OrderDetailRepository detailRepo;

	public OrderDetailServiceImpl(OrderDetailRepository detailRepository) {
		super();
		this.detailRepo = detailRepository;
	}

	@Override
	public List<OrderDetailDTO> getAllOrderDetail() {
		List<Order_Detail> details = detailRepo.findAll();
		return details.stream().map((orderDetail) -> OrderDetailMapper.mapToOrderDetailDTO(orderDetail)).collect(Collectors.toList());
	}

	@Override
	public List<OrderDetailDTO> getOrdersByOrderId(String ordersId) {
		List<Order_Detail> details = detailRepo.findOrderDetailsWithProducts(ordersId);
		return details.stream().map((orderDetail) -> OrderDetailMapper.mapToOrderDetailDTO(orderDetail)).collect(Collectors.toList());
	}

	@Override
	public List<OrderDetailDTO> getOrdersbyProductsId(String productsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetailDTO getOrderDetailbyBoth(String ordersId, String productsId) {
		Order_Detail detail = detailRepo.findOrderDetailsByBothIds(ordersId, productsId);
		return OrderDetailMapper.mapToOrderDetailDTO(detail);
	}

	@Override
	public OrderDetailDTO addOrderDetail(OrderDetailDTO dto) {
		Order_Detail detail = OrderDetailMapper.mapToOrderDetail(dto);
		Order_Detail saved_detail = detailRepo.save(detail);
		return OrderDetailMapper.mapToOrderDetailDTO(saved_detail);
	}

	@Override
	public Order_Detail updateOrderDetail(String ordersId, String productsId, Order_Detail detail) {
		Order_Detail needUpadte = detailRepo.findOrderDetailsByBothIds(ordersId, productsId);
		needUpadte.setQuantity(detail.getQuantity());
		needUpadte.setPrice(detail.getPrice());
		Order_Detail updated = detailRepo.save(needUpadte);
		return updated;
	}

	@Override
	public void deleteOrderDetail(String id) {
		List<Order_Detail> details = detailRepo.findOrderDetailsWithProducts(id);
		detailRepo.deleteAll(details);
	}

}
