package com.swp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.swp.entity.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, String> {
	Optional<Delivery> findById(String id);
	@Query(nativeQuery = true, value ="SELECT de.* FROM [Deliveries] de WHERE de.OrderID = :OrdersID")
	Delivery findDeliveryWithOrderID(@Param("OrdersID") String orderId);
	@Query(nativeQuery = true, value ="SELECT de.* FROM [Deliveries] de WHERE de.AccountID = :AccountID")
	List<Delivery> findDeliveryWithAccountID(@Param("AccountID") String accountId);
	@Query(nativeQuery = true, value ="SELECT de.* FROM [Deliveries] de WHERE de.StatusID = :StatusID")
	List<Delivery> findDeliveryWithStatusID(@Param("StatusID") int statusId);
}
