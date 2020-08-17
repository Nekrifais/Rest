package com.example.rest.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.domain.Booking;
import com.example.rest.domain.BookingDto;
import com.example.rest.domain.HotelService;
// import com.example.rest.exceptions.InvalidInputException;
// import com.example.rest.exceptions.ResourceNotFoundException;
import com.example.rest.repository.BookingRepository;
import com.example.rest.service.BookingService;
import com.example.rest.service.HotelServiceService;
import com.example.rest.service.RoomService;
import com.example.rest.service.UserService;

@Service

public class BookingServiceImpl implements BookingService {
	
	final static Logger logger = Logger.getLogger(BookingServiceImpl.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private HotelServiceService hotelServiceService;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	
	
	@Override
	public Booking create(BookingDto bookingDto) {
		
		Booking booking = new Booking();
		booking.setStartDate(bookingDto.getStartDate());
		booking.setEndDate(bookingDto.getEndDate());
		booking.setUser(userService.getUserById(bookingDto.getUserId()));
		booking.setRoom(roomService.getRoomById(bookingDto.getRoomId()));
		if (bookingDto.getHotelServiceIds() != null && bookingDto.getHotelServiceIds().size() > 0) {
			List<HotelService> hotelServices = hotelServiceService.getAllById(bookingDto.getHotelServiceIds());
			booking.setHotelServices(hotelServices);
		}
		booking = bookingRepository.save(booking);
		
		logger.info("Booking created : " + booking);
		
		return booking;
	}
	
	@Override
	public BigDecimal getTotalPrice(Long bookingId){
		Optional<Booking> booking = bookingRepository.findById(bookingId);
		

		BigDecimal totalPrice = booking.get().getRoom().getPrice()
				.multiply(new BigDecimal(ChronoUnit.DAYS.between(booking.get().getStartDate(), booking.get().getEndDate())));
				
		for (HotelService hotelService : booking.get().getHotelServices()) {
			totalPrice = totalPrice.add(hotelService.getPrice());
		}
		
		totalPrice = totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);

		logger.info("Total price of booking : " + totalPrice);
		
		return totalPrice;
	}

	@Override
	public List<Booking> getByUser(Long userId) {
		List<Booking> findedUser = bookingRepository.findByUser(userService.getUserById(userId));
		logger.info("User found  : " + findedUser);
		return bookingRepository.findByUser(userService.getUserById(userId));
	}

	@Override
	public List<Booking> getAll() {
		return bookingRepository.findAll();
	}

}
