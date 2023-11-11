package com.spring.api.security.entity;

import java.sql.Timestamp;

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

}
