package com.amolrang.modume.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {
	@RequestMapping(value = "/api/oauth2/code/twitch")
	public void twitchAPI() {
		System.out.println("twitch api oauth2 접근 확인");
	}
}
