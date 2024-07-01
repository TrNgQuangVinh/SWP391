package com.swp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	User findByEmail(String email);
}
