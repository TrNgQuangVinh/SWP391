package com.swp.mapper;

import com.swp.dto.CategoryDTO;
import com.swp.entity.Category;

public class CategoryMapper {
	public static CategoryDTO mapToCategoryDTO(Category category) {
		return new CategoryDTO(
			category.getCategoryID(),
			category.getCategoryName()
			);
		}
	public static Category mapToCategory (CategoryDTO categoryDTO) {
		return new Category(
				categoryDTO.getCategoryID(),
				categoryDTO.getCategoryName()
				);
	}
}
