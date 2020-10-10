package com.amolrang.modume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MenuController {
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu() {
			log.info("메뉴열기");
		return "/menu";
	}
}
