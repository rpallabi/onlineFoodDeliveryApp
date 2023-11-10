package com.Restaurant.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurant.entities.TableBooking;
import com.Restaurant.repository.TableBookingRepository;
import com.Restaurant.service.TableBookingService;

@Service
public class TableBookingServiceImp implements TableBookingService{

	@Autowired
	TableBookingRepository tb;

	@Override
	public TableBooking createBooking(TableBooking tablebooking) {

		return tb.save(tablebooking);
	}

	@Override
	public List<TableBooking> getAllBooking() {
		List<TableBooking> le = tb.findAll();
		return le;
	}

	@Override
	public TableBooking getBookingById(int bookingId) {
		TableBooking s = tb.findById(bookingId).get();
		return s;
	}
		@Override
		public TableBooking updateBooking(int bookingId, TableBooking tablebooking) {
			TableBooking s = tb.findById(bookingId).get();
			s.setNumberOfSeats(tablebooking.getNumberOfSeats());
			s.setRemainingSeats(tablebooking.getRemainingSeats());
			s.setBookingDate(tablebooking.getBookingDate());
			s.setPaidAmount(tablebooking.getPaidAmount());
			

			

			return tb.save(s);
		}

		@Override
		public String deleteBookingById(int bookingId) {
			tb.deleteById(bookingId);
			return "Booking is deleted";
		}

		@Override
		public String deleteBooking() {
			tb.deleteAll();
			return "All the Booking are deleted";
		}


}
