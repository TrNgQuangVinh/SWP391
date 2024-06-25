package com.swp.mapper;

import com.swp.dto.DiamondDTO;
import com.swp.dto.ProductDTO;
import com.swp.entity.Diamond;
import com.swp.entity.Product;

public class DiamondMapper {
	public static DiamondDTO mapToDiamondDTO(Diamond diam) {
		return new DiamondDTO(
				diam.getDiamondId(),
				diam.getCaratWeight(),
				diam.getColor(),
				diam.getCut(),
				diam.getClarity(),
				diam.getPrice(),
				diam.getQuantity()
				);
	}
	public static Diamond mapToDiamond(DiamondDTO diamDTO) {
		return new Diamond(
				diamDTO.getDiamondId(),
				diamDTO.getCaratWeight(),
				diamDTO.getColor(),
				diamDTO.getCut(),
				diamDTO.getClarity(),
				diamDTO.getPrice(),
				diamDTO.getQuantity()
				);
	}
}
