package com.example.rest.service;

import java.util.List;

import com.example.rest.domain.HotelService;

public interface HotelServiceService {
	
	List<HotelService> getAllById(List<Long> hotelServiceIds);

}
