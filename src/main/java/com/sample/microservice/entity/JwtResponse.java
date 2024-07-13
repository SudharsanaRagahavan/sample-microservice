package com.sample.microservice.entity;

public class JwtResponse {
	private final String token;

	public JwtResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}
