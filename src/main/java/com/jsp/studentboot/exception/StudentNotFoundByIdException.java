package com.jsp.studentboot.exception;

public class StudentNotFoundByIdException extends RuntimeException {

	private String message;
	

	public StudentNotFoundByIdException(String message) {
		super(message);
		
	}


	
}
