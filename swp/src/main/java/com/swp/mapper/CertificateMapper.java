package com.swp.mapper;

import com.swp.dto.CertificateDTO;
import com.swp.entity.Certificate;

public class CertificateMapper {
	public static Certificate mapToCertificate(CertificateDTO dto) {
		return new Certificate(
				dto.getCertificateId(),
				dto.getDate(), 
				dto.getDiamondId(),
				dto.getMeasurement());
	}
	
	public static CertificateDTO mapToCertificateDTO(Certificate cert) {
		return new CertificateDTO(
				cert.getCertificateId(), 
				cert.getDate(), 
				cert.getDiamondId(),
				cert.getMeasurement());
	}
}
