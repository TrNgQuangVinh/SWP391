package com.swp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swp.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
