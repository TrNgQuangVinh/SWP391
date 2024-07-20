package com.swp.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Certificate")
public class Certificate {
	@Id
	@Column(name = "CertificateID")
	private String certificateId;
	private Timestamp date;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DiamondID", referencedColumnName="DiamondID")
	private Diamond diamondId;	
	private String measurement;
}
