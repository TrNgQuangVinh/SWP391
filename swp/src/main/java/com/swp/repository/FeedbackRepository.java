package com.swp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swp.entity.Feedback;
import com.swp.entity.Product;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,String>{
	@Query(value="SELECT f.* "
			+ "FROM Feedback f "
			+ "INNER JOIN Products p "
			+ "ON f.ProductID = p.ProductID "
			+ "WHERE f.ProductID = :product_id", nativeQuery = true)
	List<Feedback> findByProductId(@Param("product_id")String productid);
	@Query(value="SELECT f.* "
			+ "FROM Feedback f "
			+ "INNER JOIN Products p "
			+ "ON f.ProductID = p.ProductID "
			+ "WHERE f.ProductID = :product_id "
			+ "ORDER BY f.Date DESC", nativeQuery = true)
	List<Feedback> findByProductIdOrderByDateDesc(@Param("product_id")String productid);
	@Query(value="SELECT f.* "
			+ "FROM Feedback f "
			+ "INNER JOIN Products p "
			+ "ON f.ProductID = p.ProductID "
			+ "WHERE f.ProductID = :product_id "
			+ "ORDER BY f.Date ASC", nativeQuery = true)
	List<Feedback> findByProductIdOrderByDateAsc(@Param("product_id")String productid);
}
