package com.amolrang.modume.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
public class TestController {
	@RequestMapping(value = "/api/oauth2/code/twitch")
	public void twitchAPI() {
		System.out.println("twitch api oauth2 접근");
	}
	
	public void ouauth2code() {
		
	}
}

@Data
class TwitchAPI{
	private String code;
	private static final String AUTHORIZATION_URL
    = "https://api.twitch.tv/kraken/oauth2/authorize" +
    "?response_type=code" +
    "&client_id=%s" +
    "&redirect_uri=%s" +
    "&scope=%s" +
    "&state=%s";

private static final String ACCESSTOKEN_URL
    = "https://api.twitch.tv/kraken/oauth2/token" +
    "&client_id=%s" +
    "&client_secret=%s" +
    "&grant_type=authorization_code" +
    "&redirect_uri=%s" +
    "&code=%s" +
    "&state=%s";

	protected TwitchAPI(){}
	
	private static class InstanceHolder{
		private static final TwitchAPI INSTANCE = new TwitchAPI();
	}
	
	public static TwitchAPI instance() {
		return InstanceHolder.INSTANCE;
	}

}