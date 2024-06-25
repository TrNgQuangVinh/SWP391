package com.swp.entity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
	private String productId;
	@Column
	private String productName;
	@Column
	private int productSize;
	@Column
	private float productPrice;
	@Column
	private int quantity;
	@JsonIgnore
//	@ManyToOne(fetch = FetchType.EAGER)
	
	private String categoryId;
	@JsonIgnore
//	@ManyToOne(fetch = FetchType.EAGER)
	
	private String diamondId;
	@JsonIgnore
//	@ManyToOne(fetch = FetchType.EAGER)
	
	private String shellId;
	@JsonIgnore
	@Column(name = "AccountID")
	private String accountId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AccountId", referencedColumnName="AccountID")
	@JoinColumn(name = "CategoryId", referencedColumnName="categoryId")
	@JoinColumn(name = "DiamondId", referencedColumnName="DiamondID")
	@JoinColumn(name = "ShellId", referencedColumnName="ShellID")
	
	@Override
	public int hashCode() {
		return Objects.hash(productId, productName, productPrice, productSize, /*Quantity,*/ categoryId, diamondId, shellId,
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
		return Objects.equals(productId, other.productId) && Objects.equals(productName, other.productName)
				&& Float.floatToIntBits(productPrice) == Float.floatToIntBits(other.productPrice)
				&& productSize == other.productSize && quantity == other.quantity
				&& Objects.equals(categoryId, other.categoryId) && Objects.equals(diamondId, other.diamondId)
				&& Objects.equals(shellId, other.shellId) && Objects.equals(accountId, other.accountId);
	}
	@Override
	public String toString() {
		return "Product [ProductId=" + productId + ", ProductName=" + productName + ", ProductSize=" + productSize
				+ ", ProductPrice=" + productPrice + ", Quantity=" + quantity + ", categoryId=" + categoryId
				+ ", diamondId=" + diamondId + ", shellId=" + shellId + ", accountId=" + accountId + "]";
	}
	
	
}
