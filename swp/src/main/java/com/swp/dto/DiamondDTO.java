package com.swp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiamondDTO {
	private int diamondId;
	private float caratWeight;
	private String color;
	private String cut;
	private String clarity;
	private float price;
	private int quantity;
}
