package com.amolrang.modume.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class JsonController {
	
	@RequestMapping(value = "/IdChk", produces="text/plain;charset=UTF-8")
	public String IdChk() {
		String result ="";
		
		return String.format("%s", result);
	}
}
