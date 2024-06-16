package com.swp.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	@Column
	private String ProductName;
	@Column
	private int ProductSize;
	@Column
	private float ProductPrice;
	@Column
	private int Quantity;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CategoryId", referencedColumnName="categoryId")
	private Category categoryId;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DiamondId", referencedColumnName="DiamondID")
	private Diamond diamondId;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ShellId", referencedColumnName="ShellID")
	private Shell shellId;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AccountId", referencedColumnName="AccountID")
	private User accountId;
	@Override
	public int hashCode() {
		return Objects.hash(ProductId, ProductName, ProductPrice, ProductSize, /*Quantity,*/ categoryId, diamondId, shellId,
				accountId);
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
				&& Objects.equals(shellId, other.shellId) && Objects.equals(accountId, other.accountId);
	}
	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", ProductSize=" + ProductSize
				+ ", ProductPrice=" + ProductPrice + ", Quantity=" + Quantity + ", categoryId=" + categoryId
				+ ", diamondId=" + diamondId + ", shellId=" + shellId + ", accountId=" + accountId + "]";
	}
	
}
