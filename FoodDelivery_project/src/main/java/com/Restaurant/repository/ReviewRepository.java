package com.Restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurant.entities.Review;



public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
