package com.swp.mapper;
import com.swp.entity.Cart;
import com.swp.dto.CartDTO;
public class CartMapper {
	public static CartDTO mapToCartDTO(Cart cart) {
		return new CartDTO(
				cart.getCartId(),
				cart.getAccountId(),
				cart.getTotalPrice(),
				cart.getProducts()
				);
	}
	public static Cart mapToCart(CartDTO dto) {
		return new Cart(
				dto.getCartId(),
				dto.getAccountId(),
				dto.getTotalPrice(),
				dto.getProducts()
				);
	}
}
