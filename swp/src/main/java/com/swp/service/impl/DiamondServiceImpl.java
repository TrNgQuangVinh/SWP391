package com.swp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.dto.DiamondDTO;
import com.swp.entity.Diamond;
import com.swp.entity.Product;
import com.swp.exception.DiamondNotFoundException;
import com.swp.exception.ProductNotFoundException;
import com.swp.exception.UserNotFoundException;
import com.swp.mapper.DiamondMapper;
import com.swp.repository.DiamondRepository;
import com.swp.service.DiamondService;

@Service
public class DiamondServiceImpl implements DiamondService {
	
	@Autowired
	private DiamondRepository diamRepo;
	
	public DiamondServiceImpl(DiamondRepository diamRepo) {
		super();
		this.diamRepo = diamRepo;
	}

	@Override
	public List<DiamondDTO> getDiamond() {
		List<Diamond> diamonds = diamRepo.findAll();
		return diamonds.stream().map((diamond) -> DiamondMapper.mapToDiamondDTO(diamond)).collect(Collectors.toList());
	}

	@Override
	public DiamondDTO addDiamond(DiamondDTO diamondDTO) {
		//TODO: validate diamond data to prevent duplicate everything
		//TODO: auto generate id for everything by their format (or use @ID Auto_Generated=true or smth)
		Diamond diamond = DiamondMapper.mapToDiamond(diamondDTO);
		Diamond savedDiamond = diamRepo.save(diamond);
		return DiamondMapper.mapToDiamondDTO(savedDiamond);
	}

	@Override
	public DiamondDTO updateDiamond(String id, Diamond diamond) {
		Diamond diam = diamRepo.findById(id)
				.orElseThrow(()-> new DiamondNotFoundException("Diamond does not exist with this id:" + id));
		diam.setDiamondId(diamond.getDiamondId());
		diam.setCaratWeight(diamond.getCaratWeight());
		diam.setColor(diamond.getColor());
		diam.setClarity(diamond.getClarity());
		diam.setCut(diamond.getCut());
		diam.setPrice(diamond.getPrice());
		diam.setQuantity(diamond.getQuantity());
		Diamond updatedDiamond = diamRepo.save(diam);
		return DiamondMapper.mapToDiamondDTO(updatedDiamond);
	}

	@Override
	public void deleteDiamond(String id) {
		Diamond diam = diamRepo.findById(id)
				.orElseThrow(()-> new DiamondNotFoundException("Diamond does not exist with this id:" + id));
		diamRepo.deleteById(id);
		
	}

}
