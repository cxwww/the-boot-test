package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.TokenRequestParam;
import com.example.demo.domain.TokenResponseInfo;

@RestController
public class DataController {
	
	@Autowired
	private RestTemplate rest;
	
	private static final String REMOVE_URL = "https://open.youzan.com/oauth/token";
	
	/**
	 * curl -X POST http://open.youzan.com/oauth/token 
	 * -H 'content-type: application/x-www-form-urlencoded' 
	 * -d 'client_id=testclient&client_secret=testclientsecret&grant_type=silent&kdt_id=88888'
	 */
	@RequestMapping(value="/data/token", method=RequestMethod.GET)
	public void getToken() {
		TokenRequestParam requestParam = new TokenRequestParam();
		ResponseEntity responseEntity = this.rest.postForEntity(REMOVE_URL, requestParam, TokenResponseInfo.class);
		TokenResponseInfo responseInfo = (TokenResponseInfo) responseEntity.getBody();
		System.out.println(responseInfo.toString());
	}
	
}
