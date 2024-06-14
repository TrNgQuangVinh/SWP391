package com.swp.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "Products")
public class Product {
	@Id
	@Column(name = "ProductID")
	private String ProductId;
	private String ProductName;
	private int ProductSize;
	private float ProductPrice;
	private int Quantity;
	@ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category categoryId;
	@ManyToOne
	@JoinColumn(name = "diamondId")
	private Diamond diamondId;
	@ManyToOne
	@JoinColumn(name = "shellId")
	private Shell shellId;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User userId;
	@Override
	public int hashCode() {
		return Objects.hash(ProductId, ProductName, ProductPrice, ProductSize, Quantity, categoryId, diamondId, shellId,
				userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(ProductId, other.ProductId) && Objects.equals(ProductName, other.ProductName)
				&& Float.floatToIntBits(ProductPrice) == Float.floatToIntBits(other.ProductPrice)
				&& ProductSize == other.ProductSize && Quantity == other.Quantity
				&& Objects.equals(categoryId, other.categoryId) && Objects.equals(diamondId, other.diamondId)
				&& Objects.equals(shellId, other.shellId) && Objects.equals(userId, other.userId);
	}
	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", ProductSize=" + ProductSize
				+ ", ProductPrice=" + ProductPrice + ", Quantity=" + Quantity + ", categoryId=" + categoryId
				+ ", diamondId=" + diamondId + ", shellId=" + shellId + ", userId=" + userId + "]";
	}
	
}
