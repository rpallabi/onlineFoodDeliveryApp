package com.Restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant.entities.Food;
import com.Restaurant.repository.FoodRepository;



@Service
public class Foodservice {
	@Autowired
	private FoodRepository foodRepository;

	public Food saveFoodData(Food food) {
		Food savedFood = foodRepository.save(food);
		return savedFood;
	}
	
	
	public List<Food> getAllFoods() {
		List<Food> le = foodRepository.findAll();
		return le;
	}
	
	
	public Food getFoodById(int fid) {
		Food s = foodRepository.findById(fid).get();
		return s;
	}
	
	public String deleteFoodById(int fid) {
		foodRepository.deleteById(fid);
		return "Food is deleted";
	}

	
	public String deleteFood() {
		foodRepository.deleteAll();
		return "Foods are deleted";
	}
	
	
	public Food updateFood(int fid, Food food) {
		Food s = foodRepository.findById(fid).get();
		s.setFoodname(food.getFoodname());
		s.setType(food.getType());
		s.setDescription(food.getDescription());
		s.setPrice(food.getPrice());
		s.setQuantity(food.getQuantity());
		s.setFoodImage(food.getFoodImage());

		return foodRepository.save(s);
	}

}
