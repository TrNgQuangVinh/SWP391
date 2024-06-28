package com.swp.service;

import java.util.List;

import com.swp.dto.CategoryDTO;
import com.swp.entity.Category;

public interface CategoryService {
	List<CategoryDTO> getCategory();
	CategoryDTO addCategory(CategoryDTO categoryDTO);
	Category updateCategory(String id, Category category);
	void deleteCategory(String id);
}
