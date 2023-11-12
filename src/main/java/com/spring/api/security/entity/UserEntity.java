package com.spring.api.security.entity;

import java.sql.Timestamp;

import com.spring.api.security.dto.UserDto;

import lombok.Data;

@Data
public class UserEntity {
	private long userId;
	private String userName;
	private String email;
	private String password;
	private String role;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public UserDto toDto() {
		UserDto dto = new UserDto();
		dto.setUserId(this.userId);
		dto.setUserName(this.userName);
		dto.setEmail(this.email);
		dto.setRole(this.role);
		dto.setCreatedAt(this.createdAt);
		dto.setUpdatedAt(this.updatedAt);
		return dto;
	}

}
