package com.Restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurant.entities.Food;


public interface FoodRepository extends JpaRepository<Food, Integer> {

}
