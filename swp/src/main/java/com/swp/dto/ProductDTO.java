package com.swp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private String productId;
	private String productName;
	private int productSize;
	private float productPrice;
	private int quantity;
	private String description;
	private String imageLink;
    private String categoryId;
	private String diamondId;
	private String shellId;
	private String accountId;
	private String materialId;	
}
