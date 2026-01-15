package com.pallavi.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pallavi.jobportal.entity.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

}
