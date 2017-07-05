package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/getUser")
	@Cacheable(value="user_cache")
	public User getUser() {
		User user = userService.getUser();
		System.out.println("无缓存效果");
		return user;
	}
	
	@RequestMapping("/findAll")
	public Page<User> findAll() {
		return userService.findAll();
	}
	
}
