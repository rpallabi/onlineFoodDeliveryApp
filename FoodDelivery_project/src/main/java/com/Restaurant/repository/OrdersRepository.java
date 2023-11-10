package com.Restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurant.entities.Orders;



public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
