package com.spring.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.api.security.config.UserAuthProvider;
import com.spring.api.security.dto.LoginRequestDto;
import com.spring.api.security.entity.UserEntity;

@Service
public class LoginService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthService authService;	
	
	@Autowired
	UserAuthProvider userAuthProvider;

	public ResponseEntity<Object> login(LoginRequestDto loginDto){
		UserEntity user = authService.findUserByEmail(loginDto.getEmail());
		if(user != null) {
			if(passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
				String token = userAuthProvider.createToken(loginDto.getEmail());
				return ResponseEntity.ok(token);
			}else {
				return ResponseEntity.ok("User Email or Password does not exist");
			}
			
		}else {
			return ResponseEntity.ok("User not exist");
		}
	}
}

