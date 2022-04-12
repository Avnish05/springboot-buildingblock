package com.sacksimplify.restservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sacksimplify.restservices.services.*;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
}
