package com.example.rest.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.domain.HotelService;
import com.example.rest.repository.HotelServiceRepository;
import com.example.rest.service.HotelServiceService;

@Service
public class HotelServiceServiceImpl implements HotelServiceService{
	
	final static Logger logger = Logger.getLogger(HotelServiceServiceImpl.class);
	
	@Autowired 
	private HotelServiceRepository hotelServiceRepository;
	
	@Override
	public List<HotelService> getAllById(List<Long> hotelServiceIds) {
		List<HotelService> hotelServiceById = hotelServiceRepository.findAllById(hotelServiceIds);
		logger.info("Find all Service by id : " + hotelServiceById);
		return hotelServiceRepository.findAllById(hotelServiceIds);
	}
	
}
