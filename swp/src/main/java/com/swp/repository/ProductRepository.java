package com.swp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swp.dto.ProductDTO;
import com.swp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
	@Query(value="SELECT p.* "
			+ "FROM Products p "
			+ "INNER JOIN Categories c "
			+ "ON c.CategoryID = p.CategoryID "
			+ "WHERE p.CategoryID = :category_id", nativeQuery = true)
	List<Product> findByCategoryId(@Param("category_id")String categoryid);
	@Query(value="SELECT p.*"
			+ "FROM Products p"
			+ "INNER JOIN Diamonds d"
			+ "ON d.DiamondID = p.DiamondID"
			+ "WHERE p.DiamondID = :diamond_id", nativeQuery = true)
	List<Product> findByDiamond(@Param("diamond_id")String diamondid);
	@Query(value="SELECT p.* "
			+ "FROM Products p "
			+ "INNER JOIN Shells s "
			+ "ON s.ShellID = p.ShellID "
			+ "WHERE p.ShellID = :shell_id", nativeQuery = true)
	List<Product> findByShell(@Param("shell_id")String shellid);
	@Query(value="SELECT p.* "
			+ "FROM Products p "
			+ "WHERE p.Quantity <= :quantity", nativeQuery = true)
	List<Product> findByQuantity(@Param("quantity")int quantity);
	@Query(value="SELECT p.* "
			+ "FROM Products p "
			+ "WHERE p.ProductPrice >= :priceMin AND p.ProductPrice <= :priceMax", nativeQuery = true)
	List<Product> findByPrice(@Param("priceMin")double priceMin, @Param("priceMax")double priceMax);
}
