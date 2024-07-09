package com.swp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class ProductDTO {
	private String productId;
	private String productName;
	private String productSize;
	private float productPrice;
	private int quantity;
	private String description;
	private String imageLink;
    private String categoryId;
	private String diamondId;
	private String shellId;
	private String accountId;
	private String materialId;
	
	public ProductDTO(String accountId, String categoryId, String description, String diamondId, String imageLink, String materialId, String productId,
			String productName, float productPrice, String productSize, int quatity, String shellId) {
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
