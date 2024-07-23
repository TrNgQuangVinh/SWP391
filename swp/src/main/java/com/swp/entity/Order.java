package com.swp.entity;

import java.sql.Timestamp;
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
@Table(name = "Orders")
public class Order {
	@Id
	@Column(name = "OrderID")
	private String orderId;
	@Column(name = "AccountID")
	private String accountId;
	private float totalPrice;
	private String address;
	private Timestamp date;
	private int statusId;
	
	@ManyToMany
	@JoinTable(
	  name = "Order Detail", // The name of the intermediate table
	  joinColumns = @JoinColumn(name = "OrdersID"), // The column name in OrderDetail that refers to Order's primary key
	  inverseJoinColumns = @JoinColumn(name = "ProductsID") // The column name in OrderDetail that refers to Product's primary key
	)
	private Set<Product> products; 
}
