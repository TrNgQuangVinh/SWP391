package com.swp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.swp.entity.OrderDetail;
import com.swp.entity.OrderDetailId;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
	Optional<OrderDetail> findById(OrderDetailId id);
	@Query(nativeQuery = true, value ="SELECT od.* FROM [Order Detail] od INNER JOIN Products p ON od.ProductsID = p.ProductID WHERE od.OrdersID = :OrdersID")
	List<OrderDetail> findOrderDetailsWithProducts(@Param("OrdersID") String orderId);
    @Query(nativeQuery = true, value ="SELECT od.* FROM [Order Detail] od INNER JOIN Products p ON od.ProductsID = p.ProductID WHERE od.ProductsID = :ProductsID")
    List<OrderDetail> findOrderDetailsWithProductsId(@Param("ProductsID") String productsId);
    @Query(nativeQuery = true, value ="SELECT od.* FROM [Order Detail] od INNER JOIN Products p ON od.ProductsID = p.ProductID WHERE od.OrdersID = :OrdersID and od.ProductsID = :ProductsID")
    OrderDetail findOrderDetailsByBothIds(@Param("OrdersID") String orderId,@Param("ProductsID") String productsId);
}
