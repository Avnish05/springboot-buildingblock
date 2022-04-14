package com.sacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sacksimplify.restservices.entities.User;
//import org.springframework.stereotype.Service;
import com.sacksimplify.restservices.services.UserServices;


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
	public User createUser(@RequestBody User user)
	{
		return userServices.createUser(user);
	}
	
	//getUserById method
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") long id)
	{
		return userServices.getUserById(id);
	}
	
	//updateUserById
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable("id") long id, @RequestBody User user)
	{
		return userServices.updateUserById(id, user);
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
