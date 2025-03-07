package com.devsuperior.dsecommerce.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dsecommerce.dto.CustomError;
import com.devsuperior.dsecommerce.dto.ValidationError;
import com.devsuperior.dsecommerce.services.expections.DatabaseExpection;
import com.devsuperior.dsecommerce.services.expections.MethodArgumentNotValidExpection;
import com.devsuperior.dsecommerce.services.expections.ResourceNotFoundExpection;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundExpection.class) 
	public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundExpection e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND; 
		CustomError err = new  CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseExpection.class)
	public ResponseEntity<CustomError> database(DatabaseExpection e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST; 
		CustomError err = new  CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);	
	}
	
	@ExceptionHandler(MethodArgumentNotValidExpection.class)
	public ResponseEntity<CustomError> database(MethodArgumentNotValidExpection e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY; 
		ValidationError err = new  ValidationError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);	
	}
	
}
