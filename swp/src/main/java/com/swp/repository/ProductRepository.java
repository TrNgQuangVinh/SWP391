package com.swp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swp.dto.ProductDTO;
import com.swp.entity.Category;
import com.swp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
	@Query(value="SELECT p.* "
			+ "FROM Products p "
			+ "INNER JOIN Categories c "
			+ "ON c.category_id = p.category_id "
			+ "WHERE p.category_id = :category_id", nativeQuery = true)
	Product findByCategoryId(@Param("category_id")String categoryid);
}
