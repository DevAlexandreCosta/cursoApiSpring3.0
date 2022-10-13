package com.devalexandrecosta.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.devalexandrecosta.exceptions.ExceptionsResponse;
import com.devalexandrecosta.exceptions.ResourceNotFoundException;

public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionsResponse> handleAllExceptions(
			Exception ex, WebRequest request) {
		
		ExceptionsResponse exceptionResponse = new ExceptionsResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionsResponse> handleNotFoundExceptions(
			Exception ex, WebRequest request) {
		
		ExceptionsResponse exceptionResponse = new ExceptionsResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return  new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
		 		
	}


}
