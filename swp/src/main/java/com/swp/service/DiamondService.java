package com.swp.service;

import java.util.List;

import com.swp.dto.DiamondDTO;
import com.swp.entity.Diamond;

public interface DiamondService {
	List<DiamondDTO> getDiamond();
	DiamondDTO addDiamond(DiamondDTO diamondDTO);
	DiamondDTO updateDiamond(int id, Diamond diamond);
	void deleteDiamond(int id);
}
