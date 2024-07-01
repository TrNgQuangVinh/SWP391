package com.swp.service;

import java.util.List;

import com.swp.dto.CartDTO;
import com.swp.entity.Cart;

public interface CartService {
	List<CartDTO> getAllCart();
	CartDTO getCartById(String id);
	CartDTO addCart(CartDTO dto);
	Cart updateCart(String cartId, Cart toUpdate);
	void deleteCart(String toBeDeleted);
	List<CartDTO> getCartsByUserId(String id);
}
