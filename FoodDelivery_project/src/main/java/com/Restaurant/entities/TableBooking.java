package com.Restaurant.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TableBooking")
public class TableBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Booking_id")
	int bookingId;

	@Column(name = "No_of_seats",nullable = false)
	int numberOfSeats;

	@Column(name = "Remaining_seats",nullable = false)
	int remainingSeats;
	@Temporal(TemporalType.DATE)
	@Column(name = "Booking_date",nullable = false)
	Date bookingDate;
	@Column(name = "Paid_Amount",nullable = false)
	int paidAmount;
	
	//@JsonIgnore
	//@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "U_id", referencedColumnName = "U_id")
	//public User user;
	
	@JsonBackReference
	 @ManyToOne
	    @JoinColumn(name = "U_id")
	    private User user;

	
	public TableBooking() {
       
    }
	public TableBooking(int bookingId, int numberOfSeats, int remainingSeats, Date bookingDate, int paidAmount,
			User user) {
		super();
		this.bookingId = bookingId;
		this.numberOfSeats = numberOfSeats;
		this.remainingSeats = remainingSeats;
		this.bookingDate = bookingDate;
		this.paidAmount = paidAmount;
		this.user = user;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public int getRemainingSeats() {
		return remainingSeats;
	}
	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
