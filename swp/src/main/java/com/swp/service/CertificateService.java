package com.swp.service;

import java.util.List;

import com.swp.dto.CertificateDTO;
import com.swp.entity.Certificate;

public interface CertificateService {
	List<CertificateDTO> getAllCertificate();
	CertificateDTO getCertificateById(String id);
	CertificateDTO getCertificateByDiamondId(int diamondId);
	CertificateDTO addCertificate(CertificateDTO dto);
	Certificate updateCertificate(String id, Certificate cert);
}
