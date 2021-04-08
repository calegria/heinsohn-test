package com.heinsohntest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.google.gson.Gson;
import com.heinsohntest.controller.ControllerPermutaciones;
import com.heinsohntest.dto.InputDto;
import com.heinsohntest.dto.RequestDto;
import com.heinsohntest.dto.ResponseDto;
import com.heinsohntest.service.ServicePermutaciones;

import lombok.extern.slf4j.Slf4j;



@TestPropertySource({"classpath:test.yaml"})
@SpringBootTest(
		classes={
		ServicePermutaciones.class,
		InputDto.class,
		RequestDto.class,
		ResponseDto.class,
		ControllerPermutaciones.class
		}
)
@Slf4j
class ControllerPermutacionesTest {
	
	
	@Autowired
	ControllerPermutaciones controllerPermutaciones;
	
	@Value("${request}")
	String request;
	
	@Value("${response}")
	String response;
	
	RequestDto requestDto;
	ResponseDto responseDto;

	@Test
	void case_1() {
		 log.info("Request: "+request);
		 log.info("Response: "+response);
		 this.requestDto = (RequestDto)(new Gson()).fromJson(this.request, RequestDto.class);
		 this.responseDto = (ResponseDto)(new Gson()).fromJson(this.response, ResponseDto.class);
		 
		 Assertions.assertEquals(this.responseDto, controllerPermutaciones.permutaciones(requestDto));
		
	}

}
