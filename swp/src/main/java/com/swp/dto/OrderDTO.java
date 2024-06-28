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
public class OrderDTO {
	private String orderId;
	private String accountId;
	private float totalPrice;
	private String address;
	private int statusId;
	private Set<Product> products;
	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", accountId=" + accountId + ", totalPrice=" + totalPrice + ", address="
				+ address + ", statusId=" + statusId + ", products=" + products + "]";
	}

}
