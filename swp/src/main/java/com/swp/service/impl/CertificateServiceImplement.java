package com.swp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.dto.CertificateDTO;
import com.swp.entity.Certificate;
import com.swp.exception.CertificateNotFoundException;
import com.swp.mapper.CertificateMapper;
import com.swp.repository.CertificateRepository;
import com.swp.service.CertificateService;
@Service
public class CertificateServiceImplement implements CertificateService {
	@Autowired
	private CertificateRepository repo;
	
	public CertificateServiceImplement(CertificateRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<CertificateDTO> getAllCertificate() {
		List<Certificate> certs = repo.findAll();
		return certs.stream().map((certificate) -> CertificateMapper.mapToCertificateDTO(certificate)).collect(Collectors.toList());
	}

	@Override
	public CertificateDTO getCertificateById(String id) {
		Certificate cert = repo.findByCertificateId(id).
				orElseThrow(() -> new CertificateNotFoundException("The certificate with this id does not exist"));
		return CertificateMapper.mapToCertificateDTO(cert);
	}

	@Override
	public CertificateDTO getCertificateByDiamondId(int diamondId) {
		Certificate cert = repo.findByDiamondID(diamondId);
		return CertificateMapper.mapToCertificateDTO(cert);
	}

	@Override
	public Certificate updateCertificate(String id, Certificate cert) {
		Certificate needUp = repo.findByCertificateId(id).
				orElseThrow(() -> new CertificateNotFoundException("The certificate with this id does not exist"));
		needUp.setDate(cert.getDate());
		needUp.setDiamondId(cert.getDiamondId());
		Certificate saved = repo.save(needUp);
		return saved;
	}

	@Override
	public CertificateDTO addCertificate(CertificateDTO dto) {
		Certificate cert = CertificateMapper.mapToCertificate(dto);
		Certificate saved = repo.save(cert);
		return CertificateMapper.mapToCertificateDTO(saved);
	}
	
	
}
