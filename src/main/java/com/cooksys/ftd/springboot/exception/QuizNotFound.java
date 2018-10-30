package com.cooksys.ftd.springboot.exception;


public class QuizNotFound extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public QuizNotFound() {
		this.message = "Quiz not found";
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
