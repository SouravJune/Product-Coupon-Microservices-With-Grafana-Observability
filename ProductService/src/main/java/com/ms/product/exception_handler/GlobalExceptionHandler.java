package com.ms.product.exception_handler;


import com.ms.product.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ProblemDetail> handlerResourceNotFoundException(ResourceNotFoundException exception){
		
		ProblemDetail problemDetails = ProblemDetail.forStatus(HttpStatus.NOT_ACCEPTABLE);
		problemDetails.setTitle("ResourceNotFoundException");
		problemDetails.setDetail(exception.getMessage());
		problemDetails.setType(URI.create("http://localhost:8080/api/v1/errors/resource-not-found"));
		problemDetails.setStatus(HttpStatus.NOT_FOUND);
		problemDetails.setProperty("timestamp", LocalDateTime.now());
		problemDetails.setProperty("port", 9191);
		problemDetails.setProperty("host", "localhost");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(problemDetails);
	}
}
