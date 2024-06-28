package com.swp.dto;

import com.swp.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private String ProductId;
	private String ProductName;
	private int ProductSize;
	private float ProductPrice;
	private int Quantity;
    private String categoryId;
	private String diamondId;
	private String shellId;
	private String accountId;
	private String description;	
	private String imageLink;
}
