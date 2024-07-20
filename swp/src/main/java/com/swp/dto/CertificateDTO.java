package com.swp.dto;

import java.sql.Timestamp;
import java.util.Set;

import com.swp.entity.Diamond;
import com.swp.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDTO {
	private String certificateId;
	private Timestamp date;
	private Diamond diamondId;
	private String measurement;
}
