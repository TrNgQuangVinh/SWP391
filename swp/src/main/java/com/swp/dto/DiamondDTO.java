package com.swp.dto;

import java.util.List;

import com.swp.entity.Product;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiamondDTO {
	private String diamondId;
	private float caratWeight;
	private String color;
	private String cut;
	private String clarity;
	private float price;
	private int quantity;
}
