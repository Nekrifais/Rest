package com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
