package com.Restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurant.entities.TableBooking;

public interface TableBookingRepository extends JpaRepository<TableBooking, Integer> {


}
