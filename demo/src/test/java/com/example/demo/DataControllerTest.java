package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.controller.DataController;
import com.example.demo.domain.TokenRequestParam;
import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DataControllerTest {

	MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationConnect;

	@Before
	public void setUp() throws JsonProcessingException {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();

	}

	@Test
	public void getTokenTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/data/token"))
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}

	@Test
	public void getTokenCTest() throws Exception {
		TokenRequestParam rParam = new TokenRequestParam();
		String requestJson = JSONObject.toJSONString(rParam);
		System.out.println(requestJson);
		mvc.perform(
				MockMvcRequestBuilders.post("/data/tokenC")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestJson))
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}

}
