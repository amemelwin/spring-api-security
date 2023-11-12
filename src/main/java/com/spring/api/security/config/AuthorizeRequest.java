package com.spring.api.security.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

public class AuthorizeRequest {
	static void configureAuthorizeRequests(
			AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry request) {
		request.requestMatchers(HttpMethod.POST, "/api/v1/login", "/api/v1/register").permitAll()
				.requestMatchers("/api/v1/admin/payment/**").hasAuthority("1")
				.requestMatchers("/api/v1/admin/**").hasAnyAuthority("1","2")
				.requestMatchers("/api/v1/user/**").hasAnyAuthority("1","2","3")
				.requestMatchers("/api/v1/pub/**","/api/v1/public/**").permitAll();
	}
}