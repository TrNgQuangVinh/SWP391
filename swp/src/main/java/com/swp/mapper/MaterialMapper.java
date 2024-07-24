package com.swp.mapper;

import com.swp.dto.MaterialDTO;
import com.swp.entity.Material;

public class MaterialMapper {
	public static MaterialDTO mapToMaterialDTO(Material material) {
		return new MaterialDTO(
			material.getMaterialId(),
			material.getMaterialName()
			);
		}
	public static Material mapToMaterial (MaterialDTO materialDTO) {
		return new Material(
				materialDTO.getMaterialId(),
				materialDTO.getMaterialName()
				);
	}
}
