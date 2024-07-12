package com.swp.mapper;

import com.swp.dto.FeedbackDTO;
import com.swp.entity.Feedback;

public class FeedbackMapper {
	public static FeedbackDTO mapToFeedbackDTO(Feedback feedback) {
		return new FeedbackDTO(
				feedback.getFeedbackId(),
				feedback.getFeedbackContent(),
				feedback.getRating(),
				feedback.getProductId(),
				feedback.getAccountId(),
				feedback.getDate()
			);
		}
	public static Feedback mapToFeedback (FeedbackDTO feedbackDTO) {
		return new Feedback(
				feedbackDTO.getFeedbackId(),
				feedbackDTO.getFeedbackContent(),
				feedbackDTO.getRating(),
				feedbackDTO.getProductId(),
				feedbackDTO.getAccountId(),
				feedbackDTO.getDate()
				);
	}
}
