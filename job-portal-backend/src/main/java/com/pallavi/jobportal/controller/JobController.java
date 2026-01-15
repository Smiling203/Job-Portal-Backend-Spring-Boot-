
package com.pallavi.jobportal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pallavi.jobportal.entity.Job;
import com.pallavi.jobportal.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

	private final JobService jobService;

	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	// CREATE JOB
	@PostMapping
	public ResponseEntity<Job> createJob(@RequestBody Job job) {
		return new ResponseEntity<>(jobService.createJob(job), HttpStatus.CREATED);
	}

	// Get all jobs
	@GetMapping
	public ResponseEntity<List<Job>> getAllJobs() {
		return ResponseEntity.ok(jobService.getAllJobs());
	}

	// Get job By id
	@GetMapping("/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id) {
		return ResponseEntity.ok(jobService.getJobById(id));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job job) {
		return ResponseEntity.ok(jobService.updateJob(id, job));
		
	}
	
	//delete job
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable Long id){
		jobService.deleteJob(id);
		return ResponseEntity.ok("Job Deleted successfully!!");
		
	}
}
