package com.swp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.dto.CartDTO;
import com.swp.entity.Cart;
import com.swp.exception.CartNotFoundException;
import com.swp.mapper.CartMapper;
import com.swp.repository.CartRepository;
import com.swp.service.CartService;
@Service
public class CartServiceImplement implements CartService {
	@Autowired
	private CartRepository repo;
	
	public CartServiceImplement(CartRepository cart) {
		super();
		this.repo = cart;
	}
	
	@Override
	public List<CartDTO> getAllCart() {
		List<Cart> carts = repo.findAll();
		return carts.stream().map((cart) -> CartMapper.mapToCartDTO(cart)).collect(Collectors.toList());
	}

	@Override
	public CartDTO getCartById(String id) {
		Cart cart = repo.findById(id)
				.orElseThrow(() -> new CartNotFoundException("Cart does not exist with this id: "+id));
		return CartMapper.mapToCartDTO(cart);
	}

	@Override
	public CartDTO addCart(CartDTO dto) {
		Cart cart = CartMapper.mapToCart(dto);
		Cart saved = repo.save(cart);
		return CartMapper.mapToCartDTO(saved);
	}

	@Override
	public Cart updateCart(String cartId, Cart toUpdate) {
		Cart findCart = repo.findById(cartId)
				.orElseThrow(() -> new CartNotFoundException("Cart does not exist with this id: "+cartId));
		findCart.setProducts(toUpdate.getProducts());
		findCart.setTotalPrice(toUpdate.getTotalPrice());
		Cart updated = repo.save(findCart);
		return updated;
	}

	@Override
	public void deleteCart(String toBeDeleted) {
		Cart findCart = repo.findById(toBeDeleted)
				.orElseThrow(() -> new CartNotFoundException("Cart does not exist with this id: "+toBeDeleted));
		repo.delete(findCart);
	}

}
