package com.amolrang.modume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ModumEApplication {
	@Autowired
	
	public static void main(String[] args) {
		SpringApplication.run(ModumEApplication.class, args);
		
	}

}
