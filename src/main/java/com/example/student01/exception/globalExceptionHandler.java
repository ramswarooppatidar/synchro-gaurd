package com.example.student01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.student01.error.*;

@ControllerAdvice
public class globalExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerNotFound(StudentNotFoundException e){
		System.out.println("message : "+ e.getMessage());
		ErrorResponse errorResponse = new ErrorResponse("404", e.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StudentAlreadyExistException.class)
	public ResponseEntity<ErrorResponse> handlerAlreadyExicts(StudentAlreadyExistException e){
		ErrorResponse  errorResponse = new ErrorResponse("409", e.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.CONFLICT);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleExcption(Exception e){
		ErrorResponse errorResponse = new ErrorResponse("501", "internal server error");
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
