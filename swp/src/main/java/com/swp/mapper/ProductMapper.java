package com.swp.mapper;

import com.swp.dto.ProductDTO;
import com.swp.entity.Product;

public class ProductMapper {
	public static ProductDTO mapToProductDTO(Product prod) {
		return new ProductDTO(
				prod.getProductId(),
				prod.getProductName(),
				prod.getProductSize(),
				prod.getProductPrice(),
				prod.getQuantity(),
				prod.getCategoryId(),
				prod.getDiamondId(),
				prod.getShellId(),
				prod.getAccountId(),
				prod.getMaterialId(),
				prod.getDescription(),
				prod.getImageLink()
				);
	}
	public static Product mapToProduct(ProductDTO prodDTO) {
		return new Product(
				prodDTO.getProductId(),
				prodDTO.getProductName(),
				prodDTO.getProductSize(),
				prodDTO.getProductPrice(),
				prodDTO.getQuantity(),
				prodDTO.getCategoryId(),
				prodDTO.getDiamondId(),
				prodDTO.getShellId(),
				prodDTO.getAccountId(),
				prodDTO.getMaterialId(),
				prodDTO.getDescription(),
				prodDTO.getImageLink()
				);
	}
}
