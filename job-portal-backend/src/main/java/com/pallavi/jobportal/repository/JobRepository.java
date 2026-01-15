package com.pallavi.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pallavi.jobportal.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
 
}
