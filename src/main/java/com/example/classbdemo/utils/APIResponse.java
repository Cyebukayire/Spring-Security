package com.example.classbdemo.utils;

public class APIResponse {
	
	private String message;
	
	private boolean status;

	
	
	
	public APIResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

	public APIResponse() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
