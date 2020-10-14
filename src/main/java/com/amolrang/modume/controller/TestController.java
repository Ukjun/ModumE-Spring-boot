package com.amolrang.modume.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.InputStreamEditor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amolrang.modume.config.DatabaseCoinfiguration;
import com.amolrang.modume.mapper.UserMapper;
import com.amolrang.modume.model.ChatMessage;
import com.amolrang.modume.model.UserModel;
import com.amolrang.modume.service.TestService;
import com.amolrang.modume.service.UserService;

import de.comhix.twitch.api.TwitchApi;
import de.comhix.twitch.api.oauth.ClientInformation;
import de.comhix.twitch.api.oauth.OAuthResponse;
import de.comhix.twitch.api.oauth.TwitchAuthenticator;
import de.comhix.twitch.api.oauth.TwitchAuthenticator.SecondStep;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		log.info("chatMessage : " + chatMessage.toString());
		return chatMessage;
	}
	
	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor ) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		log.info("chatMessage : " + chatMessage.toString());
		return chatMessage;
	}
	
	
	@Autowired
	private TestService service;
	
	
	String token_type;
	// String token_URL =
	// "https://id.twitch.tv/oauth2/authorize?response_type=code&client_id=nb7cdnmp6y4wuqcnfh31c92oh0k8l7&redirect_uri=http://localhost:8080/access_token";
	SecondStep TP;
	ClientInformation CIF;
	String clientID;
	String secret;
	TwitchApi tAPIApi;// = new TwitchApi(CIF, access_token);

	@RequestMapping(value = "/TwitchSet")
	@ResponseBody
	public SecondStep getCode() {
		clientID = "nb7cdnmp6y4wuqcnfh31c92oh0k8l7";
		secret = "ssno1u6u6brdmi7jkbk5no0rw6j91d";
		CIF = new ClientInformation(clientID, secret, "http://localhost:8080/");
		TP = new TwitchAuthenticator(CIF,"http://localhost:8080/getCode").doAuth();
		return TP;
	}

	@RequestMapping(value = "/getCode")
	public Observable<OAuthResponse> getCode(@RequestParam(required = false) String code) {
		System.out.println("get Code : "+code);
		return TP.getOAuthToken(code);
	}

	@RequestMapping(value = "/getToken")
	public String getToken(@RequestParam(required = true) String token) {
		return String.format("%s", token);
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
}
