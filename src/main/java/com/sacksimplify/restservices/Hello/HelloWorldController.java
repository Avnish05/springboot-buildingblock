package com.sacksimplify.restservices.Hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Controller
@RestController
public class HelloWorldController {
	@RequestMapping(method=RequestMethod.GET, path = "/helloworld")
	public String helloworld() {
		return "HelloWorld";
	}
	@GetMapping("/helloworld-bean")
	public UserDetails helloWorldBean()
	{
		return new UserDetails("Avnish","Dubey","Indore");
	}
}
