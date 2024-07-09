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
public class CartDTO {

	private String cartId;
	private String accountId;
	private float totalPrice;
	private Set<Product> products;

	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", accountId=" + accountId + ", totalPrice=" + totalPrice + ", products="
				+ products + "]";
	}

}
