package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.rest.domain.User;
import com.example.rest.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="Controller of User", description="Operations pertaining to User")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @ApiOperation(value = "View a list of Users", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<User> findAll() {
        return userService.getAllUser();
    }
	
    @ApiOperation(value = "Add a User", response = User.class)
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public User createUser(@RequestBody User user) {
		return userService.create(user);
	}
	
    @ApiOperation(value = "Search a user with an ID", response = User.class)
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public User updateOne(@PathVariable("id") Long id) {
    	return userService.getUserById(id);
    }
	
    @ApiOperation(value = "Update User with certan ID", response = User.class)
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT, produces = "application/json")
    User saveOrUpdate(@RequestBody User newUser, @PathVariable Long id) {

    	return userService.update(newUser, id);
    }
    
    @ApiOperation(value = "Delete a user")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    void deleteUser(@PathVariable Long id) {
    	userService.delete(id);
    }
    
    
	
}
