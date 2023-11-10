package com.Restaurant.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant.entities.User;
import com.Restaurant.repository.UserRepository;
import com.Restaurant.service.UserService;


@Service
public class UserServiceImp implements UserService{
	@Autowired
	UserRepository us;

	@Override
	public User createUser(User user) {

		return us.save(user);
	}

	@Override
	public List<User> getAllUser() {
		List<User> le = us.findAll();
		return le;
	}

	@Override
	public User getUserById(int id) {
		User s = us.findById(id).get();
		return s;
	}

	@Override
	public User updateUser(int id, User user) {
		User s = us.findById(id).get();
		s.setUserName(user.getUserName());
		s.setEmail(user.getEmail());
		s.setAddress(user.getAddress());
		s.setPhoneNumber(user.getPhoneNumber());
		s.setPassword(user.getPassword());

		s.setUserType(user.getUserType());

		return us.save(s);
	}

	@Override
	public String deleteUserById(int id) {
		us.deleteById(id);
		return "User is deleted";
	}

	@Override
	public String deleteUsers() {
		us.deleteAll();
		return "All the Users are deleted";
	}


}
