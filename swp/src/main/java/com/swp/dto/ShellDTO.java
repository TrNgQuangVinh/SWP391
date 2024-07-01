package com.swp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShellDTO {
	private String shellId;
	private String materialID;
	private String name;
	private float ShellPrice;
	private int quantity;
}
