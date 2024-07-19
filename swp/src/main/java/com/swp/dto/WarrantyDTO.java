package com.swp.dto;

import java.util.Date;

import com.swp.entity.Warranty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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
	private Date purchaseDate;
	private Date warrantyUntil;
}
