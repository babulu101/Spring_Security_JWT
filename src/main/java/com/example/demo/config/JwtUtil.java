package com.example.demo.config;

import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	private final String key="thisIsASecretKeyForJwtToken123456";

	public String generateToken(String username) {
		 HashMap<String,Object> hm=new HashMap<>();
		 return Jwts.builder()
		.setClaims(hm)
		.setSubject(username)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+1000 * 60 * 2))
		  .signWith(Keys.hmacShaKeyFor(key.getBytes()), SignatureAlgorithm.HS256)
		.compact()
		;
		
	}
	 public String extractUsername(String token) {
	        return getClaims(token).getSubject();
	    }
	 
	 
	 public boolean validateToken(String token) {
	        try {
	            getClaims(token);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
	 
	 
	 private Claims getClaims(String token) {
	        return Jwts.parserBuilder()
	        	    .setSigningKey(Keys.hmacShaKeyFor(key.getBytes()))
	                .build()
	                .parseClaimsJws(token)
	                .getBody();
	    }
	
	
	
}
