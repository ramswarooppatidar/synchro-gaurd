package com.example.student01.exception;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(String msg){
		super(msg);
	}
	public StudentNotFoundException() {
		
	}
}
