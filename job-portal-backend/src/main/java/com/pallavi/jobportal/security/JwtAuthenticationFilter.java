package com.pallavi.jobportal.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
      
	@Override
	protected void doFilterInternal(
			HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain) 
	throws ServletException, IOException {
		
		//Get Authorization header
		String authHeader = request.getHeader("Authorization");
		
		//Check header format
		if(authHeader != null && authHeader.startsWith("Bearer ")) {
			String Token = authHeader.substring(7);
			
			try {
				
				//Validate Token
				Claims claims = JwtUtil.validateToken(Token);
				
				String email = claims.getSubject();
				String role = claims.get("role", String.class);
				
				//Create authentication object
				UsernamePasswordAuthenticationToken authentication =
						new UsernamePasswordAuthenticationToken(email, null, null); 
				
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
						
			} catch (Exception e) {
				SecurityContextHolder.clearContext();
			}
		}
		
		filterChain.doFilter(request, response);
	}
}
