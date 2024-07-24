package com.swp.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarrantyDTO {
	private String warrantyId;
	private String accountId;
	private String productId;
	private LocalDate purchaseDate;
	private LocalDate warrantyUntil;
}
