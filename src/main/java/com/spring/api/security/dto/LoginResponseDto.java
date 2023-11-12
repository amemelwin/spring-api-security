package com.spring.api.security.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class LoginResponseDto {
	private int code;
	private String message;
	private String token;
	private UserDto user;
	
	public LoginResponseDto(HttpStatus status) {
		this.code = status.value();
	}
	

}
