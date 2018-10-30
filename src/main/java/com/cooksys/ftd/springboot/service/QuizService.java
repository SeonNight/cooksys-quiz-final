package com.cooksys.ftd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cooksys.ftd.springboot.entity.Question;
import com.cooksys.ftd.springboot.entity.Quiz;
import com.cooksys.ftd.springboot.repository.QuizRepository;

public class QuizService {
	QuizRepository quizRepository;
	
	/**
	 * Get a Collection of Quizzes
	 *
	 * @param none
	 * @return a collection of Quizzes
	 */
	public List<Quiz> getQuizzes() {
		
	}

	/**
	 * Add a quiz
	 *
	 * @param Quiz
	 * @return the quiz that was added
	 */
	public Quiz addQuiz(Quiz quiz) {
	}

	/**
	 * Delete a quiz given the name
	 *
	 * @param string name of Quiz
	 * @return the quiz that was deleted
	 */
	public Quiz deleteQuiz(String quizName) {
	}

	/**
	 * Rename a quiz
	 *
	 * @param string name of Quiz, string new name
	 * @return the quiz that was altered
	 */
	public Quiz renameQuiz(String quizName, String newName) {
		
	}

	/**
	 * Get a random question from the specified quiz
	 *
	 * @param string name of Quiz
	 * @return a random question
	 */
	public Question getRandomQuestion(String quizName) {
	}

	/**
	 * Add a question to the specified quiz
	 *
	 * @param string quizName, question
	 * @return the altered Quiz
	 */
	public Quiz addQuestion(String quizName, Question question) {
		
	}

	/**
	 * Delete a question from a quiz
	 *
	 * @param string name of Quiz, string name of question
	 * @return the deleted question
	 */
	public Question deleteQuestion(String quizName, String question) {
	}

	/**
	 * Get a grade
	 *
	 * @param Quiz
	 * @return return a float of the grade
	 */
	public float getGrade(Quiz quiz) {
		
	}
}
