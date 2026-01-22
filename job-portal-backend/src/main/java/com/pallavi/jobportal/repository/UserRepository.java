package com.pallavi.jobportal.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pallavi.jobportal.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

}
