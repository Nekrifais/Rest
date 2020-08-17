package com.example.rest.service;

import java.util.List;

import com.example.rest.domain.User;

public interface UserService {
	
	List<User> getAllUser(); 
	
	User getUserById(Long userId);
	
	User create(User user);
	
	User update(User newUser, Long userId);
	
	void delete(Long userId);
	
}
