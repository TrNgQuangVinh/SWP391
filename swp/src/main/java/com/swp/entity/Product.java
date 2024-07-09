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
	@Column(name = "DiamondID")
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
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productSize=" + productSize
				+ ", productPrice=" + productPrice + ", quantity=" + quantity + ", description=" + description
				+ ", imageLink=" + imageLink + ", categoryId=" + categoryId + ", diamondId=" + diamondId + ", shellId="
				+ shellId + ", accountId=" + accountId + ", materialId=" + materialId + "]";
	}
	
	public Product(String accountId, String categoryId, String description, String diamondId, String imageLink, String materialId, String productId,
			String productName, float productPrice, int productSize, int quatity, String shellId) {
		this.accountId = accountId;
		this.categoryId = categoryId;
		this.description = description;
		this.diamondId = diamondId;
		this.imageLink = imageLink;
		this.materialId = materialId;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productSize = productSize;
		this.quantity = quatity;
		this.shellId = shellId;
	}
}
