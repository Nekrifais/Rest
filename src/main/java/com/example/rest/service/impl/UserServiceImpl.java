package com.example.rest.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.domain.User;
import com.example.rest.repository.UserRepository;
import com.example.rest.service.UserService;
import com.example.rest.error.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUser() {
		List<User> allUser = userRepository.findAll(); 
		logger.info("Get All users" );
		return allUser;
	}
	
	@Override
	public User getUserById(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			logger.info("Not found user with id : " + userId);
			throw new UserNotFoundException(userId);
		}
		
		logger.info("Get user by id : " + user.get());
		return user.get();
	}
	
	@Override
	public User create(User user) {
		User userSaved = userRepository.save(user);
		logger.info("Save user : " + userSaved);
		return userSaved;
	}
	
	@Override
	public User update(User newUser, Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			logger.info("Not found user with id : " + userId);
			throw new UserNotFoundException(userId);
		}
		
        return userRepository.findById(userId)
                .map(x -> {
                    x.setFirstName(newUser.getFirstName());
                    x.setLastName(newUser.getLastName());
                    x.setBookings(newUser.getBookings());
                    logger.info("Update user with id : " + userId);
                    return userRepository.save(x);
                })
                .orElseGet(() -> {
                	newUser.setId(userId);
                	logger.info("Save user with id : " + userId);
                    return userRepository.save(newUser);
                });
		
		
	}
	
	@Override
	public void delete(Long userId) {
		userRepository.deleteById(userId);
		logger.info("Delete user with ID : " + userId);
	}

}
