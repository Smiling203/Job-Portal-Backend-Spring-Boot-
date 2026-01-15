package com.pallavi.jobportal.service;

import java.util.List;

import com.pallavi.jobportal.entity.Job;

public interface JobService {

	Job createJob(Job job); //post
	
	List<Job> getAllJobs();  // get
	
	Job getJobById(Long id);
	
	
	void deleteJob(Long id); //remove job by id

	Job updateJob(Long id, Job job);
	

	
	
}
