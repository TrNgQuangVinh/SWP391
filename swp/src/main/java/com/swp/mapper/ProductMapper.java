package com.swp.mapper;

import com.swp.dto.ProductDTO;
import com.swp.entity.Product;

public class ProductMapper {
	public static ProductDTO mapToProductDTO(Product prod) {
		return new ProductDTO(
				prod.getProductID(),
				prod.getProductName(),
				prod.getProductSize(),
				prod.getProductPrice(),
				prod.getQuantity(),
				prod.getCategoryID(),
				prod.getDiamondID(),
				prod.getShellID(),
				prod.getAccountID()
				);
	}
	public static Product mapToProduct(ProductDTO prodDTO) {
		return new Product(
				prodDTO.getProductID(),
				prodDTO.getProductName(),
				prodDTO.getProductSize(),
				prodDTO.getProductPrice(),
				prodDTO.getQuantity(),
				prodDTO.getCategoryID(),
				prodDTO.getDiamondID(),
				prodDTO.getShellID(),
				prodDTO.getAccountID()
				);
	}
}
