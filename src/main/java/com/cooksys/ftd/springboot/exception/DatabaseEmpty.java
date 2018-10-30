package com.cooksys.ftd.springboot.exception;

public class DatabaseEmpty extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public DatabaseEmpty() {
		this.message = "Database is empty";
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
