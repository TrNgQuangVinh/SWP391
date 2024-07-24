package com.swp.mapper;

import com.swp.dto.WarrantyDTO;
import com.swp.entity.Warranty;

public class WarrantyMapper {
	public static WarrantyDTO mapToWarrantyDTO(Warranty warr) {
		return new WarrantyDTO(
				warr.getWarrantyId(),
				warr.getAccountId(),
				warr.getProductId(),
				warr.getPurchaseDate(),
				warr.getWarrantyUntil()
				);
	}
	
	public static Warranty mapToWarranty(WarrantyDTO dto) {
		return new Warranty(
				dto.getWarrantyId(),
				dto.getAccountId(),
				dto.getProductId(),
				dto.getPurchaseDate(),
				dto.getWarrantyUntil()
				);
	}
}
