package com.spring.api.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
public class Controller {
	
	@PostConstruct
	public void test() {
		System.out.println("Hello Spring API JWT");
	}

}
