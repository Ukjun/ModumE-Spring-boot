package com.amolrang.modume.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.comhix.twitch.api.TwitchApi;
import de.comhix.twitch.api.oauth.ClientInformation;
import de.comhix.twitch.api.oauth.OAuthResponse;
import de.comhix.twitch.api.oauth.TwitchAuthenticator;
import de.comhix.twitch.api.oauth.TwitchAuthenticator.SecondStep;
import io.reactivex.Observable;

@RestController
public class TestController {
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
}