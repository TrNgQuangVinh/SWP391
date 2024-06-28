package com.swp.service;

import java.util.List;

import com.swp.dto.MaterialDTO;
import com.swp.entity.Material;

public interface MaterialService {
	List<MaterialDTO> getMaterial();
	MaterialDTO addMaterial(MaterialDTO materialDTO);
	Material updateMaterial(String id, Material material);
	void deleteMaterial(String id);
}
