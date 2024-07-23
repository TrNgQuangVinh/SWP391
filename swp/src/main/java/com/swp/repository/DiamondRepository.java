package com.swp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.swp.entity.Diamond;

@Repository
public interface DiamondRepository extends JpaRepository<Diamond,Integer> {
	@Query(value="SELECT TOP 1 d.DiamondID "
			+ "FROM Diamonds d "
			+ "ORDER BY d.DiamondID DESC", nativeQuery = true)
	int findLastId();
}
