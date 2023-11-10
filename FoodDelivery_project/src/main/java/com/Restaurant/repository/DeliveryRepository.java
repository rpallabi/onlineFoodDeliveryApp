package com.Restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurant.entities.Delivery;



public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

}
