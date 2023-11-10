package com.Restaurant.controller;



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
import org.springframework.web.bind.annotation.RestController;

import com.Restaurant.entities.User;
//import com.Restaurant.repository.UserRepository;
import com.Restaurant.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	//private Map<String, User> users = new HashMap<>();
	@Autowired
	UserService ss;

	@PostMapping("/createUser")
	ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(ss.createUser(user), HttpStatus.CREATED);
	}
	
	
	
    
	@GetMapping("/getAllUser")
	List<User> getAllUser() {
		return ss.getAllUser();
	}

	@GetMapping("/getUserById/{id}")
	User getUserById(@PathVariable int id) {
		return ss.getUserById(id);
	}

	@PutMapping("/updateUser/{id}")
	User updateUser(@PathVariable int id, @RequestBody User user) {
		return ss.updateUser(id, user);
	}

	@DeleteMapping("/deleteUserById/{id}")
	String deleteUserById(@PathVariable int id) {
		return ss.deleteUserById(id);
	}

	@DeleteMapping("/deleteUsers")
	String deleteUsers() {
		return ss.deleteUsers();
	}

}
