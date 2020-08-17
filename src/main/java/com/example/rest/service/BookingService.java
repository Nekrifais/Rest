package com.example.rest.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.rest.domain.Booking;
import com.example.rest.domain.BookingDto;
//import com.example.rest.exceptions.InvalidInputException;

public interface BookingService {
	
	Booking create(BookingDto booking);
	
	BigDecimal getTotalPrice(Long bookingId);
	
	List<Booking> getByUser(Long userId);
	
	List<Booking> getAll();
	
	
	
	
}
