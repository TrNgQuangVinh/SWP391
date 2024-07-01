package com.swp.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "Carts")
public class Cart {
	@Id
	@Column(name = "CartID")
	private String cartId;
	private String accountId;
	private float totalPrice;

	@ManyToMany
	@JoinTable(name = "Cart_Products", // The name of the intermediate table
			joinColumns = @JoinColumn(name = "CartID"), // The column name in Cart_Products that refers to Carts's
														// primary key
			inverseJoinColumns = @JoinColumn(name = "ProductID") // The column name in Cart_Products that refers to
																	// Product's primary key
	)
	private Set<Product> products;
}
