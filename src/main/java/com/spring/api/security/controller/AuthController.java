package com.spring.api.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.security.dto.LoginRequestDto;
import com.spring.api.security.service.LoginService;

import jakarta.annotation.PostConstruct;

@RestController
public class AuthController {
	
	@Autowired
	LoginService loginService;

	@PostConstruct
	public void constructor () {
		//String token = userAuthProvider.createToken("hello");
		//System.out.println("Token"+token);		
		
	}
	
	@PostMapping("api/v1/login")
	public ResponseEntity<Object> login(@RequestBody LoginRequestDto loginRequestDto) {
		return loginService.login(loginRequestDto);
	}
	
	@GetMapping("api/v1/user")
	public ResponseEntity<Object> test(){
		return ResponseEntity.ok("Valid");
	}
}
