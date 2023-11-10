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

import com.Restaurant.entities.TableBooking;
import com.Restaurant.service.TableBookingService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TableBookingController {
	@Autowired
	TableBookingService bk;

	@PostMapping("/createBooking")
	ResponseEntity<TableBooking> createBooking(@RequestBody TableBooking tablebooking) {
		return new ResponseEntity<TableBooking>(bk.createBooking(tablebooking), HttpStatus.CREATED);
	}

	@GetMapping("/getAllBooking")
	List<TableBooking> getAllBooking() {
		return bk.getAllBooking();
	}

	@GetMapping("/getBookingById/{bookingId}")
	TableBooking getBookingById(@PathVariable int bookingId) {
		return bk.getBookingById(bookingId);
	}
	

	@PutMapping("/updateBooking/{bookingId}")
	TableBooking updateBooking(@PathVariable int bookingId, @RequestBody TableBooking tablebooking) {
		return bk.updateBooking(bookingId, tablebooking);
	}

	@DeleteMapping("/deleteBookingById/{bookingId}")
	String deleteBookingById(@PathVariable int bookingId) {
		return bk.deleteBookingById(bookingId);
	}

	@DeleteMapping("/deleteBooking")
	String deleteBooking() {
		return bk.deleteBooking();
	}
}
