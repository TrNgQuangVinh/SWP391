package com.swp.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class OrderDetailId implements Serializable {
	@Id 
	private String ordersId;
	@Id
	private String productsId;
}
