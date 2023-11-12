package com.spring.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.api.security.dto.LoginRequestDto;
import com.spring.api.security.entity.UserEntity;
import com.spring.api.security.repository.AuthRepository;

@Service
public class AuthService {

	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthRepository authRepository;

	public ResponseEntity<Object> getUserByEmail(LoginRequestDto loginDto) {
		UserEntity user = authRepository.getUserByEmail(loginDto);
		return ResponseEntity.ok(user);
	}
	
	public UserEntity findUserByEmail(String email) {
		return authRepository.findUserByEmail(email);
	}
	

}
