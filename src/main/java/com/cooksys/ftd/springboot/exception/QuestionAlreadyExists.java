package com.cooksys.ftd.springboot.exception;


public class QuestionAlreadyExists extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public QuestionAlreadyExists() {
		this.message = "Question already exists";
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
