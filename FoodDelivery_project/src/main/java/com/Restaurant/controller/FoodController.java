package com.Restaurant.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Restaurant.entities.Food;
import com.Restaurant.service.Foodservice;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FoodController {
	@Autowired
	private Foodservice foodService;
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/images";
	@PostMapping("/saveFood")
	public Food saveFood(@ModelAttribute Food food, @RequestParam("image") MultipartFile file) throws IOException {
		String originalFilename = file.getOriginalFilename();
		java.nio.file.Path fileNameAndPath = Paths.get(uploadDirectory, originalFilename);
		Files.write(fileNameAndPath, file.getBytes());
		food.setFoodImage(originalFilename);

		Food savedFoodData = foodService.saveFoodData(food);
		return savedFoodData;
	}
	@GetMapping("/getAllFoods")
	List<Food> getAllFoods() {
		return foodService.getAllFoods();
	}
	@GetMapping("/getFoodById/{fid}")
	Food getFoodById(@PathVariable int fid) {
		return foodService.getFoodById(fid);
	}

	@PutMapping("/updateFood/{fid}")
	Food updateFood(@PathVariable int fid, @RequestBody Food food) {
		return foodService.updateFood(fid, food);
	}

	@DeleteMapping("/deleteFoodById/{fid}")
	String deleteFoodById(@PathVariable int fid) {
		return foodService.deleteFoodById(fid);
	}

	@DeleteMapping("/deleteFood")
	String deleteFood() {
		return foodService.deleteFood();
	}
}
