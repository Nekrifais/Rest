package com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.domain.HotelService;

public interface HotelServiceRepository  extends JpaRepository<HotelService, Long> {

}
