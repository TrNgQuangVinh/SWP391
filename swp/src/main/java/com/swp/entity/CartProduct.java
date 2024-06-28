package com.swp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cart_Products")
@IdClass(CartProductID.class)
public class CartProduct {
	@Id
	@Column(name = "CartID")
	private String cartId;
	@Id
	@Column(name = "ProductID")
	private String productId;
	private String prodName;
	private int quantity;
	private float price;
	@ManyToOne
	@JoinColumn(name = "CartID", referencedColumnName = "CartID", insertable = false, updatable = false)
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
	private Product product;

	public CartProduct(String cartId, String productId, String prodName, int quantity, float price) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.prodName = prodName;
		this.quantity = quantity;
		this.price = price;
	}

}
