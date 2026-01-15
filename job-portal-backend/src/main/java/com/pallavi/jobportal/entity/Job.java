package com.pallavi.jobportal.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@Column(length = 2000)
	private String description;
	
	private String location;
	
	private String company;
	
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name = "recruiter_id")
	private User postBy;
	
	public Job() {}
}
