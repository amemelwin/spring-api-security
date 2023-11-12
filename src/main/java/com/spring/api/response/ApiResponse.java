package com.spring.api.response;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Data;

@Data
public class ApiResponse {

	private final HttpStatus status;
	private final String message;
	private final int code;
	private final Object data;
	
	// 3 argu constructor
	
	public ApiResponse(HttpStatus status, String message, Object data ) {
		this(message,status,data);
	}
	
	public ApiResponse(HttpStatus status, Object data, String message) {
		this(message,status,data);
	}
	
	public ApiResponse(Object data, HttpStatus status,String message) {
		this(message,status,data);
	}
	
	public ApiResponse(String message,Object data, HttpStatus status) {
		this(message,status,data);
	}
	
	public ApiResponse(Object data, String message, HttpStatus status) {
		this(message,status,data);
	}
	
	public ApiResponse(String message, HttpStatus status, Object data) {
		this.code = status.value();
		this.message = message;
		this.status = status;
		this.data = data;
	}
	
	// 2 argu constructor

	public ApiResponse(String message, HttpStatus status) {
		this.code = status.value();
		this.message = message;
		this.status = status;
		this.data = new HashMap<>();
	}

	public ApiResponse(HttpStatus status, String message) {
		this.code = status.value();
		this.message = message;
		this.status = status;
		this.data = new HashMap<>();
	}

	public ResponseEntity<Object> response() {
		return new ResponseEntity<Object>(this, this.status);
	}

}
