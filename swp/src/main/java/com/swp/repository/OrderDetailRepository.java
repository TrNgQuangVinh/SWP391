package com.swp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.swp.entity.OrderDetailId;
import com.swp.entity.Order_Detail;

public interface OrderDetailRepository extends JpaRepository<Order_Detail, OrderDetailId> {
	Optional<Order_Detail> findById(OrderDetailId id);
	@Query(nativeQuery = true, value ="SELECT od.* FROM [Order Detail] od INNER JOIN Products p ON od.ProductsID = p.ProductID WHERE od.OrdersID = :OrdersID")
	List<Order_Detail> findOrderDetailsWithProducts(@Param("OrdersID") String orderId);
    @Query(nativeQuery = true, value ="SELECT od.* FROM [Order Detail] od INNER JOIN Products p ON od.ProductsID = p.ProductID WHERE od.ProductsID = :ProductsID")
    List<Order_Detail> findOrderDetailsWithProductsId(@Param("ProductsID") String productsId);
    @Query(nativeQuery = true, value ="SELECT od.* FROM [Order Detail] od INNER JOIN Products p ON od.ProductsID = p.ProductID WHERE od.OrdersID = :OrdersID and od.ProductsID = :ProductsID")
    Order_Detail findOrderDetailsByBothIds(@Param("OrdersID") String orderId,@Param("ProductsID") String productsId);
}
