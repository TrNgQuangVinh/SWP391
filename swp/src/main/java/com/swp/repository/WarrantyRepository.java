package com.swp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.swp.entity.Product;
import com.swp.entity.Warranty;

public interface WarrantyRepository extends JpaRepository<Warranty,String> {
	@Query(value="SELECT w.* "
			+ "FROM Warranty w "
			+ "INNER JOIN Accounts a "
			+ "ON a.AccountID = w.AccountID "
			+ "WHERE a.FullName = :fullName", nativeQuery = true)
	List<Warranty> findByCustomerName(@Param("fullName")String fullName);
	@Query(value="SELECT w.* "
			+ "FROM Warranty w "
			+ "INNER JOIN Products p "
			+ "ON p.ProductID = w.ProductID "
			+ "WHERE p.ProductName = :productName", nativeQuery = true)
	List<Warranty> findByProductName(@Param("productName")String productName);
}
