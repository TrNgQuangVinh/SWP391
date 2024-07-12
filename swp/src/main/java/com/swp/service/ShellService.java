package com.swp.service;

import java.util.List;

import com.swp.dto.ShellDTO;
import com.swp.entity.Shell;

public interface ShellService {
	List<ShellDTO> getShell();
	//ProductDTO getShellbyID(String id);
	List<ShellDTO> getShellbyCategory(String categoryid);
	ShellDTO addShell(ShellDTO shellDTO);
	Shell updateShell(String id, Shell shell);
	void deleteShell(String id);
}
