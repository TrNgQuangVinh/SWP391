package com.swp.service;

import java.util.List;

import com.swp.dto.CartProductDTO;
import com.swp.entity.CartProduct;

public interface CartProductService {
	List<CartProductDTO> getAllCartDetail();
	List<CartProductDTO> getCartById(String id);
	CartProductDTO getCartByBothId(String cartId, String prodId);
	CartProductDTO addCartProd(CartProductDTO dto);
	CartProduct updateCartProd(String cartId, String prodId, CartProduct prod);
	void removeCartProduct(String cartId, String prodId);
}
