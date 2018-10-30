package com.cooksys.ftd.springboot.exception;

public class QuizAlreadyExists extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public QuizAlreadyExists() {
		this.message = "Quiz already exists";
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
