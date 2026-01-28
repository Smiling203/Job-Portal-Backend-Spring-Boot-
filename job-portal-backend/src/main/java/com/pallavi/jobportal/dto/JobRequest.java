package com.pallavi.jobportal.dto;

import lombok.Data;

@Data
public class JobRequest {

    private String title;
    private String description;
    private String location;
    private double salary;
	
	public String getCompany() {
		// TODO Auto-generated method stub
		return null;
	}

}

