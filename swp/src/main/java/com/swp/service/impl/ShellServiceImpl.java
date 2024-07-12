package com.swp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.dto.ShellDTO;
import com.swp.entity.Product;
import com.swp.entity.Shell;
import com.swp.exception.ProductNotFoundException;
import com.swp.mapper.ProductMapper;
import com.swp.mapper.ShellMapper;
import com.swp.repository.ProductRepository;
import com.swp.repository.ShellRepository;
import com.swp.service.ShellService;

@Service
public class ShellServiceImpl implements ShellService {

	@Autowired
	private ShellRepository shellRepo;
	
	public ShellServiceImpl(ShellRepository shellRepo) {
		super();
		this.shellRepo = shellRepo;
	}

	@Override
	public List<ShellDTO> getShell() {
		List<Shell> shells = shellRepo.findAll();
		return shells.stream().map((shell)-> ShellMapper.mapToShellDTO(shell)).collect(Collectors.toList());
	}

	@Override
	public ShellDTO addShell(ShellDTO shellDTO) {
		Shell shell = ShellMapper.mapToShell(shellDTO);
		Shell savedShell = shellRepo.save(shell);
		return ShellMapper.mapToShellDTO(savedShell);
	}

	@Override
	public Shell updateShell(String id, Shell shell) {
		Shell shl = shellRepo.findById(id)
				.orElseThrow();
		shl.setShellId(shell.getShellId());
		shl.setName(shell.getName());
		shl.setQuantity(shell.getQuantity());
		shl.setShellPrice(shell.getShellPrice());
		Shell updatedShell = shellRepo.save(shl);
		return updatedShell;
	}

	@Override
	public void deleteShell(String id) {
		Shell shell = shellRepo.findById(id)
				.orElseThrow();//()-> new ProductNotFoundException("Shell does not exist with this id:" + id));
		shellRepo.deleteById(id);
		
	}

	@Override
	public List<ShellDTO> getShellbyCategory(String categoryid) {
		List<Shell> shells = shellRepo.findByCategoryId(categoryid);
		return shells.stream().map((shell)-> ShellMapper.mapToShellDTO(shell)).collect(Collectors.toList());
	}

}
