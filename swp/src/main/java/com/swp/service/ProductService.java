package com.swp.service;

import java.util.List;

import com.swp.dto.ProductDTO;
import com.swp.entity.Category;
import com.swp.entity.Product;

public interface ProductService {
	List<ProductDTO> getProduct();
	ProductDTO getProductbyID(String id);
	ProductDTO getProductbyCategory(String categoryid);
	ProductDTO addProduct(ProductDTO productDTO);
	Product updateProduct(String id, Product product);
	void deleteProduct(String id);
	
}
