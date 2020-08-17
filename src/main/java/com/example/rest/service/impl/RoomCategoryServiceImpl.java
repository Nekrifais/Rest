package com.example.rest.service.impl;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.domain.RoomCategory;

import com.example.rest.repository.RoomCategoryRepository;
import com.example.rest.service.RoomCategoryService;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService{
	
	
	
	@Autowired
	private RoomCategoryRepository roomCategoryRepository;

	@Override
	public RoomCategory getById(Long roomCategoryId) {
		Optional<RoomCategory> roomCategory = roomCategoryRepository.findById(roomCategoryId);
		return roomCategory.get();
	}

}
