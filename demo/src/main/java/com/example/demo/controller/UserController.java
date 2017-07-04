package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;

@RestController
@EnableAutoConfiguration
public class UserController {

	@Autowired
	UserRepository ur;
	
	@RequestMapping("/getUser")
	@Cacheable(value="user_cache")
	public User getUser() {
		System.out.println("1");
		User user = ur.findByName("a1");
		System.out.println("无缓存效果");
		return user;
	}
	
}
