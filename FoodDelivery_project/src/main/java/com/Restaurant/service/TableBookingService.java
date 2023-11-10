package com.Restaurant.service;

import java.util.List;

import com.Restaurant.entities.TableBooking;


public interface TableBookingService {
	TableBooking createBooking(TableBooking tablebooking);

	List<TableBooking> getAllBooking();

	TableBooking getBookingById(int bookingId);
	
	TableBooking updateBooking(int bookingId, TableBooking tablebooking);

	String deleteBookingById(int bookingId);

	String deleteBooking();
}
