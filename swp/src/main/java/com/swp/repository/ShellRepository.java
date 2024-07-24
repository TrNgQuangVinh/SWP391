package com.swp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.swp.entity.Shell;
public interface ShellRepository extends JpaRepository<Shell, String> {
	@Query(value="SELECT DISTINCT s.* "
			+ "FROM Shells s "
			+ "INNER JOIN Products p "
			+ "ON s.ShellID = p.ShellID "
			+ "WHERE p.CategoryID = :category_id", nativeQuery = true)
	List<Shell> findByCategoryId(@Param("category_id")String categoryid);
}
