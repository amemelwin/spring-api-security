package com.spring.api.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/api/v1/user/test")
	public String userTest() {
		return "User Testing";
	}
	
	@GetMapping("/api/v1/admin/payment/test")
	public String payment() {
		return "payment";
	}

}
