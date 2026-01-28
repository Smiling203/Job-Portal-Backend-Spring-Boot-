package com.pallavi.jobportal.dto;


import com.pallavi.jobportal.entity.Job;

import lombok.Data;

@Data
public class JobResponse {

    private Long id;
    private String title;
    private String description;
    private String location;
    private double salary;
	private String company;

    
    public JobResponse(Job job) {
        this.id = job.getId();
        this.title = job.getTitle();
        this.company = job.getCompany();
        this.location = job.getLocation();
        this.description = job.getDescription();
    }


	public JobResponse(Long id2, String title2, String company2, String location2, String description2) {
		// TODO Auto-generated constructor stub
	}



	
}

