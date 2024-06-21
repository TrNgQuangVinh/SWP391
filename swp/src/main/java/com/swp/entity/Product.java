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
	private String ProductID;
	@Column
	private String ProductName;
	@Column
	private int ProductSize;
	@Column
	private float ProductPrice;
	@Column
	private int Quantity;
	@JsonIgnore
//	@ManyToOne(fetch = FetchType.EAGER)
	
	private String CategoryID;
	@JsonIgnore
//	@ManyToOne(fetch = FetchType.EAGER)
	
	private String DiamondID;
	@JsonIgnore
//	@ManyToOne(fetch = FetchType.EAGER)
	
	private String ShellID;
	@JsonIgnore
	private String AccountID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AccountID", referencedColumnName="AccountID")
	@JoinColumn(name = "CategoryID", referencedColumnName="CategoryID")
	@JoinColumn(name = "DiamondID", referencedColumnName="DiamondID")
	@JoinColumn(name = "ShellID", referencedColumnName="ShellID")
	
	@Override
	public int hashCode() {
		return Objects.hash(ProductID, ProductName, ProductPrice, ProductSize, Quantity, CategoryID, DiamondID, ShellID,
				AccountID);
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
		return Objects.equals(ProductID, other.ProductID) && Objects.equals(ProductName, other.ProductName)
				&& Float.floatToIntBits(ProductPrice) == Float.floatToIntBits(other.ProductPrice)
				&& ProductSize == other.ProductSize && Quantity == other.Quantity
				&& Objects.equals(CategoryID, other.CategoryID) && Objects.equals(DiamondID, other.DiamondID)
				&& Objects.equals(ShellID, other.ShellID) && Objects.equals(AccountID, other.AccountID);
	}
	@Override
	public String toString() {
		return "Product [ProductID=" + ProductID + ", ProductName=" + ProductName + ", ProductSize=" + ProductSize
				+ ", ProductPrice=" + ProductPrice + ", Quantity=" + Quantity + ", CategoryID=" + CategoryID
				+ ", DiamondID=" + DiamondID + ", ShellID=" + ShellID + ", accountId=" + AccountID + "]";
	}
	
}
