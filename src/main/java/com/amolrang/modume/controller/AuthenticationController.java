package com.amolrang.modume.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amolrang.modume.mapper.UserMapper;
import com.amolrang.modume.model.UserModel;
import com.amolrang.modume.service.UserService;
import com.amolrang.modume.utils.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AuthenticationController{
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginViewFrame(Model model,Principal principal) {
		log.info("로그인페이지 GET접근 :{}",principal);
		model.addAttribute(StringUtils.TitleKey(), "로그인페이지");
		return StringUtils.LoginURLValue();
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		log.info("회원가입 get 접근");
		model.addAttribute(StringUtils.TitleKey(), "회원가입페이지");
		model.addAttribute(StringUtils.LoginURLKey(),StringUtils.LoginURLValue());
		return StringUtils.JoinURLValue();
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinAction(Model model,UserModel userModel) {
		log.info("회원가입 post 접근");
		userService.save(userModel, "ROLE_MEMBER");
		return "redirect:"+StringUtils.LoginURLValue();
	}
	
	@RequestMapping(value = "/denied")
	public String denied(Model model) {
		model.addAttribute(StringUtils.TitleKey(), "거부 당함");
		return StringUtils.Denied();
	}	
}
