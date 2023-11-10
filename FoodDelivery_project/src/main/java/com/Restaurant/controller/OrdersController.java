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

import com.Restaurant.entities.Orders;
import com.Restaurant.service.OrdersService;
;

@RestController
public class OrdersController {
	@Autowired
	OrdersService od;

	@PostMapping("/AddOrders")
	ResponseEntity<Orders> createBooking(@RequestBody Orders orders) {
		return new ResponseEntity<Orders>(od.AddOrders(orders), HttpStatus.CREATED);
	}

	@GetMapping("/getAllOrders")
	List<Orders> getAllOrders() {
		return od.getAllOrders();
	}
	@GetMapping("/getOrdersById/{orderId}")
	Orders getOrdersById(@PathVariable int orderId) {
		return od.getOrdersById(orderId);
	}

	@PutMapping("/updateOrders/{orderId}")
	Orders updateOrders(@PathVariable int orderId, @RequestBody Orders orders) {
		return od.updateOrders(orderId, orders);
	}

	@DeleteMapping("/deleteOrdersById/{orderId}")
	String deleteOrdersById(@PathVariable int orderId) {
		return od.deleteOrdersById(orderId);
	}

	@DeleteMapping("/deleteOrders")
	String deleteOrders() {
		return od.deleteOrders();
	}
}
