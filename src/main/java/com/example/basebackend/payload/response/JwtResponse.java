package com.example.basebackend.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {
	private Long id;
	private String username;
	private String email;
	private String accessToken;
	private String refreshToken;
	private String tokenType = "Bearer";
	private List<String> roles;


	public JwtResponse(String accessToken, String refreshToken, Long id, String username, String email, List<String> roles) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}
}
