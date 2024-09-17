package com.example.student01.exception;

import org.springframework.stereotype.Component;

@Component
public class StudentAlreadyExistException extends RuntimeException {
	public StudentAlreadyExistException(String msg) {
		super(msg);
	}
	public StudentAlreadyExistException(){
		
	}
}
