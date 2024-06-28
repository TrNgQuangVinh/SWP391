package com.swp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.dto.CategoryDTO;
import com.swp.entity.Category;
import com.swp.entity.Shell;
import com.swp.mapper.CategoryMapper;
import com.swp.mapper.ShellMapper;
import com.swp.repository.CategoryRepository;
import com.swp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository cateRepo;
	
	public CategoryServiceImpl(CategoryRepository cateRepo) {
		super();
		this.cateRepo = cateRepo;
	}

	@Override
	public List<CategoryDTO> getCategory() {
		List<Category> categories = cateRepo.findAll();
		return categories.stream().map((category)->CategoryMapper.mapToCategoryDTO(category)).collect(Collectors.toList());
	}

	@Override
	public CategoryDTO addCategory(CategoryDTO categoryDTO) {
		Category category = CategoryMapper.mapToCategory(categoryDTO);
		Category savedCate = cateRepo.save(category);
		return CategoryMapper.mapToCategoryDTO(savedCate);
	}

	@Override
	public Category updateCategory(String id, Category category) {
		Category cate = cateRepo.findById(id)
				.orElseThrow();
		cate.setCategoryID(category.getCategoryID());
		cate.setCategoryName(category.getCategoryName());
		Category updatedCate = cateRepo.save(cate);
		return updatedCate;
	}

	@Override
	public void deleteCategory(String id) {
		Category cate = cateRepo.findById(id)
				.orElseThrow();
		cateRepo.deleteById(id);
		
	}

}
