package com.swp.service;

import java.util.List;

import com.swp.dto.FeedbackDTO;
import com.swp.dto.ProductDTO;
import com.swp.entity.Feedback;

public interface FeedbackService {
	List<FeedbackDTO> getFeedback();
	List<FeedbackDTO> getFeedbackByProduct(String productid);
	List<FeedbackDTO> getFeedbackByProductOrderByDateDesc(String productid);
	FeedbackDTO addFeedback(FeedbackDTO materialDTO);
	Feedback updateFeedback(String id, Feedback material);
	void deleteFeedback(String id);
}
