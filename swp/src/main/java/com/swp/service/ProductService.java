package com.swp.service;

import java.util.List;

import com.swp.dto.ProductDTO;
import com.swp.entity.Category;
import com.swp.entity.Product;

public interface ProductService {
	List<ProductDTO> getProduct();
	ProductDTO getProductbyID(String id);
	List<ProductDTO> getProductbyCategory(String categoryid);
	List<ProductDTO> getProductbyDiamond(String diamondid);
	List<ProductDTO> getProductbyShell(String shellid);
	List<ProductDTO> getProductbyQuantity(int quantity);
	List<ProductDTO> getProductbyPrice(double priceMin, double priceMax);
	ProductDTO addProduct(ProductDTO productDTO);
	Product updateProduct(String id, Product product);
	void deleteProduct(String id);
	
}
