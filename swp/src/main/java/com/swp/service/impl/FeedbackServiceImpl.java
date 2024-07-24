package com.swp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.dto.FeedbackDTO;
import com.swp.entity.Feedback;
import com.swp.mapper.FeedbackMapper;
import com.swp.repository.FeedbackRepository;
import com.swp.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	private FeedbackRepository feedRepo;

	public FeedbackServiceImpl(FeedbackRepository feedRepo) {
		super();
		this.feedRepo = feedRepo;
	}

	@Override
	public List<FeedbackDTO> getFeedback() {
		List<Feedback> feedbacks = feedRepo.findAll();
		return feedbacks.stream().map((feedback) -> FeedbackMapper.mapToFeedbackDTO(feedback)).collect(Collectors.toList());

	}
	
	@Override
	public List<FeedbackDTO> getFeedbackByProduct(String id) {
		List<Feedback> feedbacks = feedRepo.findByProductId(id);
		return feedbacks.stream().map((feedback) -> FeedbackMapper.mapToFeedbackDTO(feedback)).collect(Collectors.toList());
	}

	@Override
	public FeedbackDTO addFeedback(FeedbackDTO feedbackDTO) {
		if(feedbackDTO.getDate()==null) 
		{
			LocalDate dateCurr = LocalDate.now();
			feedbackDTO.setDate(dateCurr);
		}
		Feedback feedback = FeedbackMapper.mapToFeedback(feedbackDTO);
		Feedback savedFeedback = feedRepo.save(feedback);
		return FeedbackMapper.mapToFeedbackDTO(savedFeedback);
	}

	@Override
	public Feedback updateFeedback(String id, Feedback feedback) {
		Feedback feed = feedRepo.findById(id)
				.orElseThrow();
		feed.setFeedbackId(feedback.getFeedbackId());
		feed.setFeedbackContent(feedback.getFeedbackContent());
		feed.setRating(feedback.getRating());
		feed.setProductId(feedback.getProductId());
		feed.setAccountId(feedback.getAccountId());
		Feedback updatedMat = feedRepo.save(feed);
		return updatedMat;
	}

	@Override
	public void deleteFeedback(String id) {
		Feedback feed = feedRepo.findById(id)
				.orElseThrow();
		feedRepo.deleteById(id);
		
	}

	@Override
	public List<FeedbackDTO> getFeedbackByProductOrderByDateDesc(String productid) {
		List<Feedback> feedbacks = feedRepo.findByProductIdOrderByDateDesc(productid);
		return feedbacks.stream().map((feedback) -> FeedbackMapper.mapToFeedbackDTO(feedback)).collect(Collectors.toList());
	}
	
	@Override
	public List<FeedbackDTO> getFeedbackByProductOrderByDateAsc(String productid) {
		List<Feedback> feedbacks = feedRepo.findByProductIdOrderByDateAsc(productid);
		return feedbacks.stream().map((feedback) -> FeedbackMapper.mapToFeedbackDTO(feedback)).collect(Collectors.toList());
	}
}
