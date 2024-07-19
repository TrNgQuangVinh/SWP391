package com.swp.service;

import java.util.List;

import com.swp.dto.WarrantyDTO;
import com.swp.entity.Warranty;


public interface WarrantyService {
	List<WarrantyDTO> getWarranty();
	//ProductDTO getWarrantybyID(String id);
	List<WarrantyDTO> getWarrantybyCustName(String custName);
	List<WarrantyDTO> getWarrantybyProductName(String prodName);
	WarrantyDTO addWarranty(WarrantyDTO warrantyDTO);
	Warranty updateWarranty(String id, Warranty warranty);
	void deleteWarranty(String id);
}
