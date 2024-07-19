package com.swp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.dto.WarrantyDTO;
import com.swp.entity.Warranty;
import com.swp.mapper.WarrantyMapper;
import com.swp.repository.WarrantyRepository;
import com.swp.service.WarrantyService;
@Service
public class WarrantyServiceImpl implements WarrantyService {

	@Autowired
	private WarrantyRepository warrRepo;
	
	public WarrantyServiceImpl(WarrantyRepository warrRepo) {
		super();
		this.warrRepo = warrRepo;
	}

	@Override
	public List<WarrantyDTO> getWarranty() {
		List<Warranty> warranties = warrRepo.findAll();
		return warranties.stream().map((warrgory)->WarrantyMapper.mapToWarrantyDTO(warrgory)).collect(Collectors.toList());
	}

	@Override
	public List<WarrantyDTO> getWarrantybyCustName(String custName) {
		List<Warranty> warranties = warrRepo.findByCustomerName(custName);
		return warranties.stream().map((warrback) ->WarrantyMapper.mapToWarrantyDTO(warrback)).collect(Collectors.toList());
	}

	@Override
	public List<WarrantyDTO> getWarrantybyProductName(String prodName) {
		List<Warranty> warranties = warrRepo.findByProductName(prodName);
		return warranties.stream().map((warrback) -> WarrantyMapper.mapToWarrantyDTO(warrback)).collect(Collectors.toList());
	}

	@Override
	public WarrantyDTO addWarranty(WarrantyDTO warrantyDTO) {
		Warranty warrgory = WarrantyMapper.mapToWarranty(warrantyDTO);
		Warranty savedWarr = warrRepo.save(warrgory);
		return WarrantyMapper.mapToWarrantyDTO(savedWarr);
	}

	@Override
	public Warranty updateWarranty(String id, Warranty warranty) {
		Warranty warr = warrRepo.findById(id)
				.orElseThrow();
		warr.setWarrantyId(warr.getWarrantyId());
		warr.setAccountId(warr.getAccountId());
		warr.setProductId(warr.getProductId());
		warr.setPurchaseDate(warr.getPurchaseDate());
		warr.setWarrantyUntil(warr.getWarrantyUntil());
		Warranty updatedWarr = warrRepo.save(warr);
		return updatedWarr;
	}

	@Override
	public void deleteWarranty(String id) {
		Warranty warr = warrRepo.findById(id)
				.orElseThrow();
		warrRepo.deleteById(id);
	}

}
