
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

import com.pallavi.jobportal.dto.JobRequest;
import com.pallavi.jobportal.dto.JobResponse;
import com.pallavi.jobportal.entity.Job;
import com.pallavi.jobportal.service.JobService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/jobs")
@Tag(name = "Job APIs", description = "Create, Read, Update & Delete Jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // ✅ CREATE JOB (DTO based)
    @PostMapping
    public ResponseEntity<JobResponse> createJob(
            @Valid @RequestBody JobRequest request) {

        Job job = new Job();
        job.setTitle(request.getTitle());
        job.setCompany(request.getCompany());
        job.setLocation(request.getLocation());
        job.setDescription(request.getDescription());

        Job savedJob = jobService.createJob(job);

        JobResponse response = new JobResponse(
                savedJob.getId(),
                savedJob.getTitle(),
                savedJob.getCompany(),
                savedJob.getLocation(),
                savedJob.getDescription()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //  GET ALL JOBS
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    //  GET JOB BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    // UPDATE JOB
    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(
            @PathVariable Long id,
            @RequestBody Job job) {

        return ResponseEntity.ok(jobService.updateJob(id, job));
    }

    //  DELETE JOB
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok("Job deleted successfully");
    }
}
