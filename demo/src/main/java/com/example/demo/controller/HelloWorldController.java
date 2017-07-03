package com.example.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.component.DemoProperties;

@RestController
@EnableAutoConfiguration
public class HelloWorldController {
	
	@RequestMapping("/")
	public String index() {
		return "home";
	}
	
	@RequestMapping("/getUser")
	public User getUser() {
		User user = new User();
		user.setName("username");
		user.setPassword("password");
		return user;
	}
	
	@RequestMapping("/getDemoP")
	public DemoProperties getDemoP() {
		return new DemoProperties();
	}
	
}
