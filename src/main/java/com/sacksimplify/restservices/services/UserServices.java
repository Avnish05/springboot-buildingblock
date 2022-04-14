package com.sacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacksimplify.restservices.entities.User;
import com.sacksimplify.restservices.repositories.UserRepository;

@Service
public class UserServices{
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	//Create user service
	public User createUser(User user)
	{
		return userRepository.save(user);
	}
	
	//get user by id
	
	public Optional<User> getUserById(long id)
	{
		Optional<User> user = userRepository.findById(id);
		return user;
	}
	
	//upadateUserById method
	
	public User updateUserById(long id,User user)
	{
		user.setId(id);
		return userRepository.save(user);
	}
	
	
	//deleteUserById
	
	public void deleteUserById(long id)
	{
		if(userRepository.findById(id).isPresent())
		{
			userRepository.deleteById(id);	
		}
		
	}
	
	//getUserByUserName
	public User findByUserName(String username)
	{
		return userRepository.findByUsername(username);
	}
	
	
}
