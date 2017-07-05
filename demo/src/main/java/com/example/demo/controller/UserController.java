package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/getUser")
	@Cacheable(value="user_cache")
	public User getUser() {
		System.out.println(userRepository);
		User user = userRepository.findByName("a1");
		System.out.println("无缓存效果");
		return user;
	}
	
}
