package com.Restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurant.entities.OrderItems;


public interface OrderItemRepository extends JpaRepository<OrderItems, Integer> {

}
