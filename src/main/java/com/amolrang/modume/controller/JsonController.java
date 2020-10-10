package com.amolrang.modume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amolrang.modume.model.UserModel;
import com.amolrang.modume.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class JsonController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/IdChk", produces="text/plain;charset=UTF-8")
	public String IdChk(@RequestBody UserModel param) {
		String result ="2";
		if(userService.loadUserByUsername(param.getId()) != null ) {
			result = "3";
		}
		return String.format("%s", result);
	}
}
