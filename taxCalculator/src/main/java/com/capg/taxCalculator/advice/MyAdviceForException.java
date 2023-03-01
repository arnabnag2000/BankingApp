package com.capg.taxCalculator.advice;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;





@RestControllerAdvice
public class MyAdviceForException {

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ae) {

		String s=ae.getMessage();
		
		if(s.contains("Required request body is missing"))
			return new ResponseEntity<String>("REQUEST IS MISSING BODY", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<String>("REQUEST IS MISSING SOME FIELDS", HttpStatus.BAD_REQUEST);
		
			
	}
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<String> handleMissingRequestHeaderException(MissingRequestHeaderException ae) {

		String s=ae.getMessage();
		
		if(s.contains("Required request header 'Authorization'"))
			return new ResponseEntity<String>("REQUEST IS MISSING JWT AUTHORIZATION HEADER", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<String>("REQUEST IS MISSING SOME FIELDS", HttpStatus.BAD_REQUEST);
		
			
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException be) {
		return new ResponseEntity<String>("MEDIA REQUEST TYPE NOT SUPPORTED FOR THIS REQUEST", HttpStatus.BAD_REQUEST);
	}

}