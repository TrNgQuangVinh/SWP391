package com.swp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swp.entity.CartProduct;
import com.swp.entity.CartProductID;
@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, CartProductID> {
	Optional<CartProduct> findById(CartProductID id);
	@Query(nativeQuery = true, value = "SELECT cart.* FROM [Cart_Products] cart INNER JOIN Products p ON cart.ProductID = p.ProductID WHERE cart.CartID = :CartID")
	List<CartProduct> findCartProductsById(@Param("CartID")String cartId);
	@Query(nativeQuery = true, value = "SELECT cart.* FROM [Cart_Products] cart INNER JOIN Products p ON cart.ProductID = p.ProductID WHERE cart.CartID = :CartID and cart.ProductID = :ProductID")
	CartProduct findCartProductsByBoth(@Param("CartID")String cartId,@Param("ProductID")String prodId);
}
