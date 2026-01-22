package com.pallavi.jobportal.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
	
	 private String email;
	    private String password;

	    public LoginRequest() {}

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    public String getUsername() {
	        return password;
	    }

	    public String getPassword() {
	        return password;
	    }

}
