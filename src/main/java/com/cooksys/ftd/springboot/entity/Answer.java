package com.cooksys.ftd.springboot.entity;

public class Answer {
	private String answer;
	private boolean correct;

	public Answer() {
	}

	public Answer(String answer, boolean correct) {
		this.answer = answer;
		this.correct = correct;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
}
