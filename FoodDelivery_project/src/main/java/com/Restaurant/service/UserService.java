package com.Restaurant.service;

import java.util.List;

import com.Restaurant.entities.User;


public interface UserService {
	User createUser(User user);

	List<User> getAllUser();

	User getUserById(int id);

	User updateUser(int id, User user);

	String deleteUserById(int id);

	String deleteUsers();

}
