package com.amolrang.modume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amolrang.modume.config.DatabaseCoinfiguration;
import com.amolrang.modume.mapper.UserMapper;
import com.amolrang.modume.model.UserModel;
import com.amolrang.modume.service.TestService;
import com.amolrang.modume.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {
	
	@Autowired
	private TestService service;
	
	@RequestMapping( value = "/test", produces="text/plain;charset=UTF-8")
	public String test() {
		String result = "test";
		log.info(result);
		return String.format("%s", result);
	}
	
	@Autowired
	UserService userService;

	@Autowired
	UserMapper userMapper;
	
	
	//ADMIN 계정 부여
	@GetMapping("/create")
	public UserModel create(){
		UserModel userModel = new UserModel();
		userModel.setId("admin");
		userModel.setPassword("1234");
		userService.save(userModel, "ROLE_ADMIN");
		return userModel;
	}

	@RequestMapping(value = "/admin", produces = "text/plain;charset=UTF-8")
	public String admin() {
		String result ="";
		result = "권한접근";
		return String.format("%s", result);
	}
	
	@RequestMapping(value = "/twitch/")
	public String twitchChannel() {
		
		return "/twitch";
	}
}
