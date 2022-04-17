package com.sacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sacksimplify.restservices.entities.User;
import com.sacksimplify.restservices.exceptions.UserExistException;
import com.sacksimplify.restservices.exceptions.UserNotFoundException;
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
	public User createUser(User user) throws UserExistException
	{
		//if user exist 
		User userExists= userRepository.findByUsername(user.getUsername());
		// check 
		if(userExists!= null)
		{
			throw new UserExistException("User already exists!!");
		}
		return userRepository.save(user);
	}
	
	//getUserById
	
	public Optional<User> getUserById(long id) throws UserNotFoundException
	{
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent())
		{
			throw new UserNotFoundException("User not found in repository");
		}
		return user;
	}
	
	//upadateUserById method
	
	public User updateUserById(long id,User user) throws UserNotFoundException
	{
		
		Optional<User> optionalUser = userRepository.findById(id);
		
		if(!optionalUser.isPresent())
		{
			throw new UserNotFoundException("User not found in repository, please provide correct used id");
		}
		user.setId(id);
		return userRepository.save(user);
	}
	
	
	//deleteUserById
	
	public void deleteUserById(long id)
	{
		
		Optional<User> optionalUser= userRepository.findById(id);
		if(!optionalUser.isPresent())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not found in repository, please provide correct used id");
		}
		
//		if(userRepository.findById(id).isPresent())
//		{
//			userRepository.deleteById(id);	
//		}
		
	}
	
	//getUserByUserName
	public User findByUserName(String username)
	{
		return userRepository.findByUsername(username);
	}
	
	
}
