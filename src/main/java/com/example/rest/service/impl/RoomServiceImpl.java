package com.example.rest.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.domain.Room;
import com.example.rest.domain.RoomCategory;
import com.example.rest.repository.RoomRepository;
import com.example.rest.service.RoomCategoryService;
import com.example.rest.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	
	final static Logger logger = Logger.getLogger(RoomServiceImpl.class);
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private RoomCategoryService roomCategoryService;

	@Override
	public Room getRoomById(Long roomId) {
		Optional<Room> room = roomRepository.findById(roomId);
		logger.info("Get room by id : " + room.get());
		return room.get();
	}
	
	@Override
	public List<Room> getFreeRoomsByDates(LocalDate startDate, LocalDate endDate) {
		List<Room> roomByDate = roomRepository.findFreeRoomsByDates(startDate, endDate);
		logger.info("Get rooms betwen dates : " + roomByDate);
		return roomByDate;
	}

	@Override
	public List<Room> getByRoomCategory(Long roomCategoryId) {
		RoomCategory roomCategory = roomCategoryService.getById(roomCategoryId);
		logger.info("Get rooms by category : " + roomCategory);
		return roomRepository.findByRoomCategory(roomCategory);
	}

}
