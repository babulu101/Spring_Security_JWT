package com.example.demo.config;

import lombok.Data;

@Data
public class JwtRequest {
	private String username;
	private String password;

}
