package com.cooksys.ftd.springboot.exception;

public class QuestionNotFound extends Exception {
	private static final long serialVersionUID = 1L;

	private String message;

	public QuestionNotFound() {
		this.message = "Question not found";
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
