package com.pallavi.jobportal.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

	private static final String SECRET_KEY = "mysecretkeymysecretkeymysecretkey";

	private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

	private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

	public static String generateToken(String username, String role) {
		return Jwts.builder().setSubject(username).claim("role", role).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(key, SignatureAlgorithm.HS256).compact();
	}

	public static Claims validateToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}


	
}
