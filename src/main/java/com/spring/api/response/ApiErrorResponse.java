package com.spring.api.response;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Data;

@Data
public class ApiErrorResponse {
	
	Map<String, Object> responseBody = new LinkedHashMap<>();
	private final HttpStatus status;
	
	public ApiErrorResponse(Map<String, Object> errors,HttpStatus status,String message) {
		this(message, status, errors);
	}
	
	public ApiErrorResponse(HttpStatus status,Map<String, Object> errors,String message) {
		this(message, status, errors);
	}
	
	public ApiErrorResponse(HttpStatus status,String message,Map<String, Object> errors) {
		this(message, status, errors);
	}
	
	public ApiErrorResponse(Map<String, Object> errors,String message,HttpStatus status) {
		this(message, status, errors);
	}
	
	public ApiErrorResponse(String message,Map<String, Object> errors,HttpStatus status) {
		this(message, status, errors);
	}
	
	public ApiErrorResponse(String message, HttpStatus status,Map<String, Object> errors) {
		this.status = status;
		this.responseBody.put("code", status.value());
		this.responseBody.put("status", status);
		this.responseBody.put("message", message);
		this.responseBody.put("errors", errors);
	}

	public ResponseEntity<Object> response() {
		return new ResponseEntity<Object>(this.responseBody, this.status);
	}

}