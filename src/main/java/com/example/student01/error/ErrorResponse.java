package com.example.student01.error;

import org.springframework.stereotype.Component;

@Component
public class ErrorResponse {
	private String codeString;
	private String message;
	public String getCodeString() {
		return codeString;
	}
	public void setCodeString(String codeString) {
		this.codeString = codeString;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorResponse() {
		
	}
	public ErrorResponse(String codeString, String message) {
		this.codeString = codeString;
		this.message = message;
	}
	
	
}
