package com.swp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.swp.entity.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, String> {
	Optional<Certificate> findByCertificateId(String id);
	@Query(nativeQuery = true, value = "SELECT cert.* FROM Certificate cert WHERE cert.DiamondID = :DiamondID")
	Certificate findByDiamondID(@Param("DiamondID") int diamondId);
}
