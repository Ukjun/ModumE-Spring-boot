package com.amolrang.modume.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

import com.amolrang.modume.model.ChatMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		log.info("chatMessage : {}" + chatMessage.toString());
		return chatMessage;
	}
	
	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor ) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		log.info("chatMessage : {}" + chatMessage.toString());
		return chatMessage;
	}
}
