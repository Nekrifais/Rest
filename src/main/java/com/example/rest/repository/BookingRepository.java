package com.example.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.domain.Booking;
import com.example.rest.domain.User;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	List<Booking> findByUser(User user);
	
	List<Booking> findAll();

}
