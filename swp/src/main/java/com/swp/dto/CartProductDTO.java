package com.swp.dto;

import java.util.Set;

import com.swp.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartProductDTO {
	private String cartId;
	private String productId;
	private String prodName;
	private int quantity;
	private float price;

	@Override
	public String toString() {
		return "CartProductDTO [cartId=" + cartId + ", productId=" + productId + ", prodName=" + prodName
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}

}
