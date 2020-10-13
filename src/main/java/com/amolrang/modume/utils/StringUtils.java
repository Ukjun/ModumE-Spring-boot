package com.amolrang.modume.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringUtils {
	
	private static String kakao_client_id = "a81cf46edcab4d18e69068167b660345";
	private static String kakao_secret = "H45ITgTIbIJSX6bEAJTCAgZ5nozeMLEU";
	
	private static String twitch_client_id = "nb7cdnmp6y4wuqcnfh31c92oh0k8l7";
	private static String twitch_client_secret = "f5j8kw8fjmp0oq3g4c6xhvojirqb62";
	
	private static String redirect_uri = "http://localhost:8080/api/oauth2/";
	
	//타이틀 화면 키,
	public final static String TitleKey() {return "title";}
	
	//로그인 화면 키,값
	public final static String LoginURLKey() {return "login";}
	public final static String LoginURLValue() {return "/login";}
	
	//회원가입 화면 키,값
	public final static String JoinURLKey() {return "join";}
	public final static String JoinURLValue() {return "/join";}

	//거부 당한 경로,
	public final static String Denied() {return "/denied";}
}
