package com.heinsohntest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:application.yaml"})
public class HeinsohnTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeinsohnTestApplication.class, args);
	}

}
