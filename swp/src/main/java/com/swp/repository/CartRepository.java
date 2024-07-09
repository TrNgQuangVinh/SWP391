package com.swp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swp.entity.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
	@Query(nativeQuery = true, value = "SELECT cart.* FROM [Carts] cart WHERE cart.AccountID = :AccountID")
	List<Cart> findCartsById(@Param("AccountID")String userId);
}
