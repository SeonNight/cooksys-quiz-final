package com.cooksys.ftd.springboot.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Controller Advice to handler Exceptions
@RestControllerAdvice
public class ControllerAdvice {
	@ExceptionHandler(DatabaseEmpty.class)
	public ResponseMessage databaseEmtpy(DatabaseEmpty e) {
		return new ResponseMessage(e.getMessage());
	}

	@ExceptionHandler(QuizNotFound.class)
	public ResponseMessage quizNotFound(QuizNotFound e) {
		return new ResponseMessage(e.getMessage());
	}

	@ExceptionHandler(QuizAlreadyExists.class)
	public ResponseMessage quizAlreadyExists(QuizAlreadyExists e) {
		return new ResponseMessage(e.getMessage());
	}

	@ExceptionHandler(QuestionNotFound.class)
	public ResponseMessage questionNotFound(QuestionNotFound e) {
		return new ResponseMessage(e.getMessage());
	}

	@ExceptionHandler(QuestionAlreadyExists.class)
	public ResponseMessage questionAlreadyExists(QuestionAlreadyExists e) {
		return new ResponseMessage(e.getMessage());
	}
}
