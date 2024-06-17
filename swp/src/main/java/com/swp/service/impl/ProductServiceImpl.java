package com.swp.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.dto.ProductDTO;
import com.swp.entity.Category;
import com.swp.entity.Product;
import com.swp.exception.ProductNotFoundException;
import com.swp.exception.UserNotFoundException;
import com.swp.mapper.ProductMapper;
import com.swp.mapper.UserMapper;
import com.swp.repository.ProductRepository;
import com.swp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository prodRepo;
	
	public ProductServiceImpl(ProductRepository prodRepo) {
		super();
		this.prodRepo = prodRepo;
	}
	
	@Override
	public List<ProductDTO> getProduct() {
		List<Product> products = prodRepo.findAll();
		return products.stream().map((product) -> ProductMapper.mapToProductDTO(product)).collect(Collectors.toList());
	}

	@Override
	public ProductDTO getProductbyID(String id) {
		Product product = prodRepo.findById(id)
		.orElseThrow(()->new ProductNotFoundException("Product does not exist with this id:" + id));
		return ProductMapper.mapToProductDTO(product);
	}
	
	@Override
	public ProductDTO getProductbyCategory(String categoryid) {
		Product products = prodRepo.findByCategoryId(categoryid);
		if(products == null) {
			throw new ProductNotFoundException("Invalid Category");
		}
		//return products.stream().map((product) -> ProductMapper.mapToProductDTO(product)).collect(Collectors.toList());
		return ProductMapper.mapToProductDTO(products);
	}

	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		Product product = ProductMapper.mapToProduct(productDTO);
		Product savedProduct = prodRepo.save(product);
		return ProductMapper.mapToProductDTO(savedProduct);
		
	}

	@Override
	public Product updateProduct(String id, Product product) {
		Product prod = prodRepo.findById(id)
				.orElseThrow();
		prod.setCategoryId(product.getCategoryId());
		prod.setDiamondId(product.getDiamondId());
		prod.setProductId(product.getProductId());
		prod.setProductName(product.getProductName());
		prod.setProductPrice(product.getProductPrice());
		prod.setProductSize(product.getProductSize());
		prod.setQuantity(product.getQuantity());
		prod.setShellId(product.getShellId());
		prod.setAccountId(product.getAccountId());
		Product updatedProd = prodRepo.save(prod);
		return product;
	}

	@Override
	public void deleteProduct(String id) {
		Product prod = prodRepo.findById(id)
				.orElseThrow(()-> new ProductNotFoundException("Product does not exist with this id:" + id));
		prodRepo.deleteById(id);
		
	}


}
