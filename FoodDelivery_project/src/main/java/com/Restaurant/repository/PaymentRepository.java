package com.Restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurant.entities.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
