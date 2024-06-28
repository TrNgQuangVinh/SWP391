package com.swp.mapper;

import com.swp.dto.ShellDTO;
import com.swp.entity.Shell;

public class ShellMapper {
	public static ShellDTO mapToShellDTO(Shell shell) {
		return new ShellDTO(
				shell.getShellId(),
				shell.getMaterialID(),
				shell.getName(),
				shell.getShellPrice(),
				shell.getQuantity()
				);
	}
	public static Shell mapToShell(ShellDTO shell) {
		return new Shell(
				shell.getShellId(),
				shell.getMaterialID(),
				shell.getName(),
				shell.getShellPrice(),
				shell.getQuantity()
				);
	}
}
