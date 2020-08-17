package com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.domain.RoomCategory;

public interface RoomCategoryRepository extends JpaRepository<RoomCategory, Long> {

}
