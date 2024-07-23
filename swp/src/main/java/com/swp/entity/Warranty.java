package com.swp.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@EqualsAndHashCode
@Entity
@Table(name="Warranty")
public class Warranty {
	@Id
	@Column(name="WarrantyID")
	private String warrantyId;
	@Column(name="AccountID")
	private String accountId;
	@Column(name="ProductID")
	private String productId;
	@Column
	private LocalDate purchaseDate;
	@Column
	private LocalDate warrantyUntil;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProductID", referencedColumnName="ProductID")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AccountId", referencedColumnName="AccountID")
	
	@Override
	public String toString() {
		return "Warranty [warrantyId=" + warrantyId + ", accountId=" + accountId + ", productId=" + productId
				+ ", purchaseDate=" + purchaseDate + ", warrantyUntil=" + warrantyUntil + "]";
	}
	
	
	
}
