package com.sacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacksimplify.restservices.entities.Order;
import com.sacksimplify.restservices.entities.User;
import com.sacksimplify.restservices.exceptions.UserNotFoundException;
import com.sacksimplify.restservices.repositories.OrderRepository;
import com.sacksimplify.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value="/users")
public class OrderController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	@GetMapping("/{userid}/orders")
	public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException
	{
		
		Optional<User> userOptional= userRepository.findById(userid);
		
		if(!userOptional.isPresent())
		{
			throw new UserNotFoundException("User not found");	
		}
		return userOptional.get().getOrders();
		
	}
	
	
	@PostMapping("{userid}/orders")
	public Order createOrder(@PathVariable Long userid,@RequestBody Order order ) throws UserNotFoundException
	{
Optional<User> userOptional= userRepository.findById(userid);
		
		if(!userOptional.isPresent())
		{
			throw new UserNotFoundException("User not found");	
		}
		
		User user= userOptional.get();
		order.setUser(user);
		return orderRepository.save(order);
		
	}
	
	@GetMapping("{userid}/orders/{orderid}")
	public List<Order> getOrderByOrderId(@PathVariable Long userid,@RequestBody Order order,@PathVariable Long orderid ) throws UserNotFoundException
	{
Optional<User> userOptional= userRepository.findById(userid);
		
		if(!userOptional.isPresent())
		{
			throw new UserNotFoundException("User not found");	
		}
		
		User user= userOptional.get();
		order.setUser(user);
		return userOptional.get().getOrders();
	}
}
