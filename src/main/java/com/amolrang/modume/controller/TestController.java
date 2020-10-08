package com.amolrang.modume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amolrang.modume.repository.MemberModel;
import com.amolrang.modume.service.TestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {
	
	@Autowired
	private TestService service;
	
	@RequestMapping( value = "/test", produces="text/plain;charset=UTF-8")
	public String test() {
		String result = "";
		for(MemberModel vo : service.getMembers()) {
			result += vo.toString()+"\n";
		}
		return String.format("%s", result);
	}
}
