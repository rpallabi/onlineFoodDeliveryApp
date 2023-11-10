package com.Restaurant.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant.entities.Review;
import com.Restaurant.repository.ReviewRepository;
import com.Restaurant.service.ReviewService;


@Service
public class ReviewServiceImp implements ReviewService{
	@Autowired
	ReviewRepository rv;

	@Override
	public Review AddReview(Review review) {

		return rv.save(review);
	}

	@Override
	public List<Review> getAllReviews() {
		List<Review> le = rv.findAll();
		return le;
	}
	
	@Override
	public Review getReviewById(int ratingNo) {
		Review s = rv.findById(ratingNo).get();
		return s;
	}

	@Override
	public Review updateReview(int ratingNo, Review review) {
		Review s = rv.findById(ratingNo).get();
		s.setRatingNo(review.getRatingNo());
		s.setTotalrating(review.getTotalrating());
		//s.setFoods(review.getFoods());
		
		return rv.save(s);
	}

	@Override
	public String deleteReviewById(int ratingNo) {
		rv.deleteById(ratingNo);
		return "Review is deleted";
	}

	@Override
	public String deleteReview() {
		rv.deleteAll();
		return "All the Reviews are deleted";
	}


}
