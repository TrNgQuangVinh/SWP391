package com.swp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp.dto.FeedbackDTO;
import com.swp.entity.Feedback;
import com.swp.service.FeedbackService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedService;

	public FeedbackController(FeedbackService feedService) {
		super();
		this.feedService = feedService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<FeedbackDTO>> getFeedback(){
		return ResponseEntity.ok(feedService.getFeedback());
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<FeedbackDTO>> getFeedbackByProduct(@PathVariable("id") String id){
		if (id == null || id.trim().isEmpty()) {
			// Return an appropriate response or throw a custom exception
			return ResponseEntity.badRequest().body(null);
		}
		return ResponseEntity.ok(feedService.getFeedbackByProduct(id));
	}
	
	@GetMapping("/get/{id}/desc")
	public ResponseEntity<List<FeedbackDTO>> getFeedbackByProductOrderedDesc(@PathVariable("id") String id){
		if (id == null || id.trim().isEmpty()) {
			// Return an appropriate response or throw a custom exception
			return ResponseEntity.badRequest().body(null);
		}
		return ResponseEntity.ok(feedService.getFeedbackByProductOrderByDateDesc(id));
	}
	
	@GetMapping("/get/{id}/asc")
	public ResponseEntity<List<FeedbackDTO>> getFeedbackByProductOrderedAsc(@PathVariable("id") String id){
		if (id == null || id.trim().isEmpty()) {
			// Return an appropriate response or throw a custom exception
			return ResponseEntity.badRequest().body(null);
		}
		return ResponseEntity.ok(feedService.getFeedbackByProductOrderByDateAsc(id));
	}
	
	@PostMapping
	public ResponseEntity<FeedbackDTO> createFeedback(@RequestBody FeedbackDTO feedDTO) {
		FeedbackDTO savedFeedback = feedService.addFeedback(feedDTO);
		return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Feedback> updateFeedback(@PathVariable("id") String feedId, @RequestBody Feedback feed) {
		Feedback upFeed = feedService.updateFeedback(feedId, feed);
		return ResponseEntity.ok(upFeed);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteFeedback(@PathVariable("id") String feedID) {
		feedService.deleteFeedback(feedID);
		return ResponseEntity.ok("Feedback of this id " + feedID + " has been deleted");
	}

}
