package com.example.rest.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.domain.Booking;
import com.example.rest.domain.Room;
import com.example.rest.service.RoomService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/room")
@Api(value="Controller of room", description="Operations pertaining to Room")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@ApiOperation(value = "Get all Availables rooms", response = Room.class)
	@RequestMapping(value = "/getAvailableRooms", method = RequestMethod.GET)
	public List<Room> getAvailableRooms(@RequestParam(value = "startDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, 
										@RequestParam(value = "endDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {	
		return roomService.getFreeRoomsByDates(startDate, endDate);
	}
	
	@ApiOperation(value = "Get room by category", response = Room.class)
	@RequestMapping(value = "/getRoomsByCategory", method = RequestMethod.GET)
	public List<Room> getRoomsByCategory(@RequestParam(value = "categoryId", required = true) Long categoryId) {	
		return roomService.getByRoomCategory(categoryId);
	}
	
}
