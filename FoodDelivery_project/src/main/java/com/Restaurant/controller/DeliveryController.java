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

import com.Restaurant.entities.Delivery;
import com.Restaurant.service.DeliverService;

@RestController
public class DeliveryController {
	@Autowired
	DeliverService dd;

	@PostMapping("/AddDelivery")
	ResponseEntity<Delivery> AddDelivery(@RequestBody Delivery delivery) {
		return new ResponseEntity<Delivery>(dd.AddDelivery(delivery), HttpStatus.CREATED);
	}

	@GetMapping("/getAllDeliveryDetails")
	List<Delivery> getAllDeliveryDetails() {
		return dd.getAllDeliveryDetails();
	}
	
	@GetMapping("/getDeliveryById/{deliveryid}")
	Delivery getDeliveryById(@PathVariable int deliveryid) {
		return dd.getDeliveryById(deliveryid);
	}

	@PutMapping("/updateDelivery/{deliveryid}")
	Delivery updateDelivery(@PathVariable int deliveryid, @RequestBody Delivery delivery) {
		return dd.updateDelivery(deliveryid, delivery);
	}

	@DeleteMapping("/deleteDeliveryById/{deliveryid}")
	String deleteDeliveryById(@PathVariable int deliveryid) {
		return dd.deleteDeliveryById(deliveryid);
	}

	@DeleteMapping("/deleteDelivery")
	String deleteDelivery() {
		return dd.deleteDelivery();
	}
}
