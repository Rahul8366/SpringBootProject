package com.jsp.studentboot.config;

import org.springframework.http.HttpStatus;

public class ResponceStructure<T> {

	private int status;
	private String message;
	private Object data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int found) {
		this.status = found;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
