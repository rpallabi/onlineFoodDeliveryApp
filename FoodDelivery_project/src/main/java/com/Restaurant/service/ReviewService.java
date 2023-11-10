package com.Restaurant.service;

import java.util.List;

import com.Restaurant.entities.Review;


public interface ReviewService {
	Review AddReview(Review review);

	List<Review> getAllReviews();
	
	Review getReviewById(int ratingNo);
	
	Review updateReview(int ratingNo, Review review);

	String deleteReviewById(int ratingNo);

	String deleteReview();
}
