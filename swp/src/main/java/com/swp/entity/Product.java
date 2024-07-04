package com.swp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;
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
	@Column
	private String description;
	@Column(name="ImageLink")
	private String imageLink;
	@JsonIgnore
	// @ManyToOne(fetch = FetchType.EAGER)

	private String categoryId;
	@JsonIgnore
	// @ManyToOne(fetch = FetchType.EAGER)

	private String diamondId;
	@JsonIgnore
	// @ManyToOne(fetch = FetchType.EAGER)

	private String shellId;
	@JsonIgnore
	@Column(name = "AccountID")
	private String accountId;
	@Column(name = "MaterialID")
	private String materialId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AccountId", referencedColumnName="AccountID")
	@JoinColumn(name = "CategoryId", referencedColumnName="categoryId")
	@JoinColumn(name = "DiamondId", referencedColumnName="DiamondID")
	@JoinColumn(name = "ShellId", referencedColumnName="ShellID")
	@JoinColumn(name = "MaterialId", referencedColumnName="MaterialID")

	@Override
	public int hashCode() {
		return Objects.hash(accountId, categoryId, description, diamondId, imageLink, materialId, productId,
				productName, productPrice, productSize, quantity, shellId);
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
		return Objects.equals(accountId, other.accountId) && Objects.equals(categoryId, other.categoryId)
				&& Objects.equals(description, other.description) && Objects.equals(diamondId, other.diamondId)
				&& Objects.equals(imageLink, other.imageLink) && Objects.equals(materialId, other.materialId)
				&& Objects.equals(productId, other.productId) && Objects.equals(productName, other.productName)
				&& Float.floatToIntBits(productPrice) == Float.floatToIntBits(other.productPrice)
				&& productSize == other.productSize && quantity == other.quantity
				&& Objects.equals(shellId, other.shellId);
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productSize=" + productSize
				+ ", productPrice=" + productPrice + ", quantity=" + quantity + ", description=" + description
				+ ", imageLink=" + imageLink + ", categoryId=" + categoryId + ", diamondId=" + diamondId + ", shellId="
				+ shellId + ", accountId=" + accountId + ", materialId=" + materialId + "]";
	}
}
