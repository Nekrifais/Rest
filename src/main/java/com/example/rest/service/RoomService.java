package com.example.rest.service;

import java.time.LocalDate;
import java.util.List;

import com.example.rest.domain.Room;

public interface RoomService {
	
	Room getRoomById(Long roomId);
	
	List<Room> getFreeRoomsByDates(LocalDate startDate, LocalDate endDate);
	
	List<Room> getByRoomCategory(Long roomCategoryId);

}
