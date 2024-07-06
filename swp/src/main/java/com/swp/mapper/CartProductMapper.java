package com.swp.mapper;

import com.swp.entity.CartProduct;
import com.swp.dto.CartProductDTO;

public class CartProductMapper {
	public static CartProductDTO mapToCartProductDTO(CartProduct cart) {
		return new CartProductDTO(
				cart.getCartId(),
				cart.getProductId(),
				cart.getProductName(),
				cart.getProductSize(),
				cart.getQuantity(),
				cart.getPrice()
				);
	}
	
	public static CartProduct mapToCartProduct(CartProductDTO dto) {
		return new CartProduct(
				dto.getCartId(),
				dto.getProductId(),
				dto.getProdName(),
				dto.getProductSize(),
				dto.getQuantity(),
				dto.getPrice()
				);
	}
}
