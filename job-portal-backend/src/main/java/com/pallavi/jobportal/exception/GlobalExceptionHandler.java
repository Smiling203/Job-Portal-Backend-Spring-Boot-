package com.pallavi.jobportal.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 404 NOT FOUND
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFound(
	        ResourceNotFoundException ex) {

	    System.out.println("EXCEPTION MESSAGE: " + ex.getMessage());

	    Map<String, Object> error = new HashMap<>();
	    error.put("timestamp", LocalDateTime.now());
	    error.put("status", HttpStatus.NOT_FOUND.value());
	    error.put("error", "Not Found");
	    error.put("message", ex.getMessage());

	    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

    
    // 405 METHOD NOT ALLOWED
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleMethodNotSupported(
            HttpRequestMethodNotSupportedException ex) {

        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", HttpStatus.METHOD_NOT_ALLOWED.value());
        error.put("error", "Method Not Allowed");
        error.put("message", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    }

    // 500 INTERNAL SERVER ERROR
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(
            Exception ex) {

        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("error", "Internal Server Error");
        error.put("message", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
