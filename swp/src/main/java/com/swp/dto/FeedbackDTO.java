package com.swp.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {
	private String feedbackId;
	private String feedbackContent;
	private float rating;
	private String productId;
	private String accountId;
	private LocalDate Date;
}
