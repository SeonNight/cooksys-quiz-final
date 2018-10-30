package com.cooksys.ftd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.springboot.entity.Question;
import com.cooksys.ftd.springboot.entity.Quiz;
import com.cooksys.ftd.springboot.service.QuizService;

@RestController
public class QuizController {

	private QuizService quizService;

	@Autowired
	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}

	/**
	 * Get a Collection of Quizzes
	 *
	 * @param none
	 * @return a collection of Quizzes
	 */
	@GetMapping("quiz")
	public List<Quiz> getQuizzes() {
		return this.quizService.getQuizzes();
	}

	/**
	 * Add a quiz
	 *
	 * @param RequestBody Quiz
	 * @return the quiz that was added
	 */
	@PostMapping("quiz")
	public Quiz addQuiz(@RequestBody Quiz quiz) {
		return this.quizService.addQuiz(quiz);
	}

	/**
	 * Delete a quiz given the name
	 *
	 * @param PathVariable string name of Quiz
	 * @return the quiz that was deleted
	 */
	@DeleteMapping("quiz/{quizName}")
	public Quiz deleteQuiz(@PathVariable("quizName") String quizName) {
		return this.quizService.deleteQuiz(quizName);
	}

	/**
	 * Rename a quiz
	 *
	 * @param PathVariable string name of Quiz, pathvariable string new name
	 * @return the quiz that was altered
	 */
	@PatchMapping("quiz/{quizName}/rename/{newName}")
	public Quiz renameQuiz(@PathVariable("quizName") String quizName, @PathVariable("newName") String newName) {
		return this.quizService.renameQuiz(quizName, newName);
	}

	/**
	 * Get a random question from the specified quiz
	 *
	 * @param PathVariable string name of Quiz
	 * @return a random question
	 */
	@GetMapping("quiz/{quizName}/random")
	public Question getRandomQuestion(@PathVariable("name") String quizName) {
		return this.quizService.getRandomQuestion(quizName);
	}

	/**
	 * Add a question to the specified quiz
	 *
	 * @param PathVariable string quizName, Request BodyQuestion question
	 * @return the altered Quiz
	 */
	@PatchMapping("quiz/{quizName}/add")
	public Quiz addQuestion(@PathVariable("quizName") String quizName, @RequestBody Question question) {
		return this.quizService.addQuestion(quizName, question);
	}

	/**
	 * Delete a question from a quiz
	 *
	 * @param PathVariable string name of Quiz, PathVariable string name of question
	 * @return the deleted question
	 */
	@DeleteMapping("quiz/{quizName}/delete/{question}")
	public Question deleteQuestion(@PathVariable("quizName") String quizName,
			@PathVariable("question") String question) {
		return this.quizService.deleteQuestion(quizName, question);
	}

	/**
	 * Get a grade
	 *
	 * @param Quiz
	 * @return return a float of the grade
	 */
	@PostMapping("quiz/grade")
	public float getGrade(Quiz quiz) {
		return this.quizService.getGrade(quiz);
	}
}
