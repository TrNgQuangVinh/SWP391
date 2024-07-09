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
@Table(name = "Order Detail")
@IdClass(OrderDetailId.class)
public class OrderDetail {
	@Id
	@Column(name = "OrdersID")
	private String ordersId;
	@Id
    @Column(name = "ProductsID")
	private String productsId;
	@Column(name = "ProductsSize")
	private float productsSize;
	private int quantity;
	private float price;
	@ManyToOne
    @JoinColumn(name = "OrdersID", referencedColumnName = "OrderID", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ProductsID", referencedColumnName = "ProductID", insertable = false, updatable = false)
    private Product product;
	@Override
	public String toString() {
		return "Order_Detail [odersId=" + ordersId + ", productsId=" + productsId + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	public OrderDetail(String ordersId,String productsId, float productsSize, int quantity, float price) {
		this.ordersId = ordersId;
		this.productsId = productsId;
		this.productsSize = productsSize;
		this.quantity = quantity;
		this.price = price;
	}
}
