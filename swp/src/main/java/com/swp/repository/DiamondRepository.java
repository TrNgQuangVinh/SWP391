package com.swp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swp.entity.Diamond;

@Repository
public interface DiamondRepository extends JpaRepository<Diamond,String> {
	
}
