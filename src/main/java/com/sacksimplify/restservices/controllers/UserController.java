package com.sacksimplify.restservices.controllers;

//import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.sacksimplify.restservices.entities.User;
import com.sacksimplify.restservices.exceptions.UserExistException;
import com.sacksimplify.restservices.exceptions.UserNotFoundException;
//import org.springframework.stereotype.Service;
import com.sacksimplify.restservices.services.UserServices;

//import src.main.java.com.stacksimplify.restservices.controllers.Void;
//import src.main.java.com.stacksimplify.restservices.exceptions.UserExistException;


@RestController
public class UserController {

	@Autowired
	private UserServices userServices;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userServices.getAllUsers();
	}
	
	//create user method
	@PostMapping("/users")
	public User createUser(@RequestBody User user, UriComponentsBuilder builder) 
	{
		try {
			return userServices.createUser(user);
//			HttpHeaders headers = new HttpHeaders();
//			headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getUserid()).toUri());
//			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			
		} catch(UserExistException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}
	
	
	
	//getUserById method
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") long id)
	{
		try
		{ 
		return userServices.getUserById(id);
		}catch(UserNotFoundException ex)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
	
	
	
	//updateUserById
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable("id") long id, @RequestBody User user) 
	{
		try
		{
			return userServices.updateUserById(id, user);	
		}catch(UserNotFoundException ex)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
		}
		
	}
	
	//deleteUserById method
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") long id)
	{
		userServices.deleteUserById(id);
	}
	
	@GetMapping("/users/byusername/{username}")
	public User findByUserName(@PathVariable("username") String username)
	{
		return userServices.findByUserName(username);
	}
	
	
	
}
