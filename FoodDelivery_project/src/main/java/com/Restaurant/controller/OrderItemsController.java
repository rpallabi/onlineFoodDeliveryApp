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

import com.Restaurant.entities.OrderItems;
import com.Restaurant.service.OrderItemsService;

@RestController
public class OrderItemsController {
	@Autowired
	OrderItemsService oi;

	@PostMapping("/AddOrderItems")
	ResponseEntity<OrderItems> AddOrderItems(@RequestBody OrderItems orderitems) {
		return new ResponseEntity<OrderItems>(oi.AddOrderItems(orderitems), HttpStatus.CREATED);
	}

	@GetMapping("/getAllOrderItems")
	List<OrderItems> getAllOrderItems() {
		return oi.getAllOrderItems();
	}

	@GetMapping("/getOrderItemsById/{orderItemId}")
	OrderItems getOrderItemsById(@PathVariable int orderItemId) {
		return oi.getOrderItemsById(orderItemId);
	}

	@PutMapping("/updateOrderItems/{orderItemId}")
	OrderItems updateOrderItems(@PathVariable int orderItemId, @RequestBody OrderItems orderitems) {
		return oi.updateOrderItems(orderItemId, orderitems);
	}

	@DeleteMapping("/deleteOrderItemsById/{orderItemId}")
	String deleteOrderItemsById(@PathVariable int orderItemId) {
		return oi.deleteOrderItemsById(orderItemId);
	}

	@DeleteMapping("/deleteOrderItems")
	String deleteOrderItems() {
		return oi.deleteOrderItems();
	}
}
