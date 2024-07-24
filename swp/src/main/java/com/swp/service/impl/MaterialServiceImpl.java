package com.swp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.dto.MaterialDTO;
import com.swp.entity.Material;
import com.swp.mapper.MaterialMapper;
import com.swp.repository.MaterialRepository;
import com.swp.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService{
	
	@Autowired
	private MaterialRepository matRepo;

	public MaterialServiceImpl(MaterialRepository matRepo) {
		super();
		this.matRepo = matRepo;
	}

	@Override
	public List<MaterialDTO> getMaterial() {
		List<Material> materials = matRepo.findAll();
		return materials.stream().map((material) -> MaterialMapper.mapToMaterialDTO(material)).collect(Collectors.toList());

	}

	@Override
	public MaterialDTO addMaterial(MaterialDTO materialDTO) {
		Material material = MaterialMapper.mapToMaterial(materialDTO);
		Material savedMaterial = matRepo.save(material);
		return MaterialMapper.mapToMaterialDTO(savedMaterial);
	}

	@Override
	public Material updateMaterial(String id, Material material) {
		Material mat = matRepo.findById(id)
				.orElseThrow();
		mat.setMaterialId(material.getMaterialId());
		mat.setMaterialName(material.getMaterialName());
		Material updatedMat = matRepo.save(mat);
		return updatedMat;
	}

	@Override
	public void deleteMaterial(String id) {
		Material mat = matRepo.findById(id)
				.orElseThrow();
		matRepo.deleteById(id);
		
	}
	

}
