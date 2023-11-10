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

import com.Restaurant.entities.Payment;
import com.Restaurant.service.PaymentService;


@RestController
public class PaymentController {
	@Autowired
	PaymentService rs;

	@PostMapping("/CreatePayment")
	ResponseEntity<Payment> CreatePayment(@RequestBody Payment payment) {
		return new ResponseEntity<Payment>(rs.CreatePayment(payment), HttpStatus.CREATED);
	}

	@GetMapping("/getAllPayments")
	List<Payment> getAllPayments() {
		return rs.getAllPayments();
	}
	@GetMapping("/getPaymentById/{pid}")
	Payment getUserById(@PathVariable int pid) {
		return rs.getPaymentById(pid);
	}

	@PutMapping("/updatePayment/{pid}")
	Payment updatePayment(@PathVariable int pid, @RequestBody Payment payment) {
		return rs.updatePayment(pid, payment);
	}

	@DeleteMapping("/deletePaymentById/{pid}")
	String deleteUserById(@PathVariable int pid) {
		return rs.deletePaymentById(pid);
	}

	@DeleteMapping("/deletePayment")
	String deleteUsers() {
		return rs.deletePayment();
	}
}
