package com.spring.api.security.config;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

	private UserAuthProvider userAuthProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (header != null) {
			String[] elements = header.split(" ");

			if (elements.length == 2 && "Bearer".equals(elements[0])) {
				try {
					SecurityContextHolder.getContext().setAuthentication(userAuthProvider.validateToken(elements[1]));
				} catch (RuntimeException e) {
					SecurityContextHolder.clearContext();
					throw e;
				}
			}
		}
		filterChain.doFilter(request, response);
	}
}