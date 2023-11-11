package com.spring.api.security.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.api.security.dto.LoginRequestDto;
import com.spring.api.security.entity.UserEntity;

@Mapper
public interface AuthRepository {
	public UserEntity getUserByEmail(LoginRequestDto loginDto);
	public UserEntity findUserByEmail(@Param("email") String email);
}
