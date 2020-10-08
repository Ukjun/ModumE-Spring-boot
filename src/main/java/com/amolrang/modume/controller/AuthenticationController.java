package com.amolrang.modume.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amolrang.modume.model.UserModel;


@Controller
public class AuthenticationController{
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginViewFrame(Model model) {
		System.out.println("로그인 페이지 get 접근");
		model.addAttribute("title", "로그인페이지");
		return "/login";
	}
	
	@RequestMapping(value = "/loginAction", method = RequestMethod.POST)
	public String loginAction(Model model) {
		System.out.println("로그인 페이지 post 접근");
		model.addAttribute("title", "로그인 중 ...");
		return "redirect:/login";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		System.out.println("회원가입 get 접근");
		model.addAttribute("title", "회원가입페이지");
		return "/join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinAction(Model model) {
		System.out.println("회원가입 post 접근");
		model.addAttribute("title", "회원가입중");
		return "redirect:/login";
	}
	
}
