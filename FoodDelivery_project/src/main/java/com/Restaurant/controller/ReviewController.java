package com.Restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Restaurant.entities.Review;
import com.Restaurant.service.ReviewService;

@RestController
public class ReviewController {
	@Autowired
	ReviewService rs;

	@PostMapping("/AddReview")
	ResponseEntity<Review> AddReview(@RequestBody Review review) {
		return new ResponseEntity<Review>(rs.AddReview(review), HttpStatus.CREATED);
	}

	@GetMapping("/getAllReviews")
	List<Review> getAllReviews() {
		return rs.getAllReviews();
	}
	@GetMapping("/getReviewById/{ratingNo}")
	Review getReviewById(@PathVariable int ratingNo) {
		return rs.getReviewById(ratingNo);
	}

	@PutMapping("/updateReview/{ratingNo}")
	Review updateReview(@PathVariable int ratingNo, @RequestBody Review review) {
		return rs.updateReview(ratingNo, review);
	}

	@DeleteMapping("/deleteReviewById/{ratingNo}")
	String deleteUserById(@PathVariable int ratingNo) {
		return rs.deleteReviewById(ratingNo);
	}

	@DeleteMapping("/deleteReview")
	String deleteUsers() {
		return rs.deleteReview();
	}
}
