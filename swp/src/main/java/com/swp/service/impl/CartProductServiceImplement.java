package com.swp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.dto.CartProductDTO;
import com.swp.entity.CartProduct;
import com.swp.mapper.CartProductMapper;
import com.swp.repository.CartProductRepository;
import com.swp.service.CartProductService;

@Service
public class CartProductServiceImplement implements CartProductService {
	@Autowired
	private CartProductRepository repo;
	
	public CartProductServiceImplement(CartProductRepository repository) {
		super();
		this.repo = repository;
	}

	@Override
	public List<CartProductDTO> getAllCartDetail() {
		List<CartProduct> carts = repo.findAll();
		return carts.stream().map((cartProduct) -> CartProductMapper.mapToCartProductDTO(cartProduct)).collect(Collectors.toList());
	}

	@Override
	public List<CartProductDTO> getCartById(String id) {
		List<CartProduct> cart = repo.findCartProductsById(id);
		return cart.stream().map((cartProduct) -> CartProductMapper.mapToCartProductDTO(cartProduct)).collect(Collectors.toList());
	}

	@Override
	public CartProductDTO getCartByBothId(String cartId, String prodId) {
		CartProduct cart = repo.findCartProductsByBoth(cartId, prodId);
		return CartProductMapper.mapToCartProductDTO(cart);
	}

	@Override
	public CartProductDTO addCartProd(CartProductDTO dto) {
		CartProduct cartProd = CartProductMapper.mapToCartProduct(dto);
		CartProduct saved = repo.save(cartProd);
		return CartProductMapper.mapToCartProductDTO(saved);
	}

	@Override
	public CartProduct updateCartProd(String cartId, String prodId, CartProduct prod) {
		CartProduct update = repo.findCartProductsByBoth(cartId, prodId);
		update.setPrice(prod.getPrice());
		update.setQuantity(prod.getQuantity());
		CartProduct saved = repo.save(update);
		return saved;
	}

	@Override
	public void removeCartProduct(String cartId, String prodId) {
		CartProduct delete = repo.findCartProductsByBoth(cartId, prodId);
		repo.delete(delete);
	}
	
}
