package com.spring.api.security.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
	private String email;
	private String password;
}
