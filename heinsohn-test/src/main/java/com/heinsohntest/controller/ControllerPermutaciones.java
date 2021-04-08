package com.heinsohntest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.heinsohntest.dto.RequestDto;
import com.heinsohntest.dto.ResponseDto;
import com.heinsohntest.service.ServicePermutaciones;


@RestController
public class ControllerPermutaciones {
	
	@Autowired
	ServicePermutaciones servicePermutaciones;

	@PostMapping({ "${url}" })
	public ResponseDto permutaciones(@Validated @RequestBody RequestDto request) {
		return ResponseDto.builder().output(this.servicePermutaciones.init(request)).build();
		
	}
}
