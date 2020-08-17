package com.example.rest.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.domain.Booking;
import com.example.rest.domain.BookingDto;
import com.example.rest.domain.User;
import com.example.rest.service.BookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/booking")
@Api(value="Controller of Booking", description="Operations pertaining to Booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@ApiOperation(value = "Create a booking", response = Booking.class)
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Booking createBooking(@RequestBody BookingDto bookingDto) {
		return bookingService.create(bookingDto);
	}
	
	@ApiOperation(value = "Get Total price for booking", response = Booking.class)
	@RequestMapping(value = "/getTotalPrice", method = RequestMethod.GET)
	public BigDecimal getTotalPrice(@RequestParam(value = "bookingId", required = true) Long bookingId){
		return bookingService.getTotalPrice(bookingId);
	}
	
	@ApiOperation(value = "Get booking by User", response = Booking.class)
	@RequestMapping(value = "/getByUser", method = RequestMethod.GET)
	public List<Booking> getByUser(@RequestParam(value = "userId", required = true) Long userId){
		return bookingService.getByUser(userId);
	}
	
	@ApiOperation(value = "Get all booking", response = Booking.class)
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Booking> getAll(){
		return bookingService.getAll();
	}
	
}
