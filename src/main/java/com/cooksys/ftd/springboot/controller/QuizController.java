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
import com.cooksys.ftd.springboot.exception.QuestionAlreadyExists;
import com.cooksys.ftd.springboot.exception.QuestionNotFound;
import com.cooksys.ftd.springboot.exception.QuizAlreadyExists;
import com.cooksys.ftd.springboot.exception.QuizNotFound;
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
	 * @throws QuizNotFound 
	 */
	@GetMapping("quiz")
	public List<Quiz> getQuizzes() throws QuizNotFound {
		return this.quizService.getQuizzes();
	}

	/**
	 * Add a quiz
	 *
	 * @param RequestBody Quiz
	 * @return the quiz that was added
	 * @throws QuizAlreadyExists 
	 */
	@PostMapping("quiz")
	public Quiz addQuiz(@RequestBody Quiz quiz) throws QuizAlreadyExists {
		return this.quizService.addQuiz(quiz);
	}

	/**
	 * Delete a quiz given the name
	 *
	 * @param PathVariable string name of Quiz
	 * @return the quiz that was deleted
	 * @throws QuizNotFound 
	 */
	@DeleteMapping("quiz/{quizName}")
	public Quiz deleteQuiz(@PathVariable("quizName") String quizName) throws QuizNotFound {
		return this.quizService.deleteQuiz(quizName);
	}

	/**
	 * Rename a quiz
	 *
	 * @param PathVariable string name of Quiz, pathvariable string new name
	 * @return the quiz that was altered
	 * @throws QuizNotFound 
	 */
	@PatchMapping("quiz/{quizName}/rename/{newName}")
	public Quiz renameQuiz(@PathVariable("quizName") String quizName, @PathVariable("newName") String newName) throws QuizNotFound {
		return this.quizService.renameQuiz(quizName, newName);
	}

	/**
	 * Get a random question from the specified quiz
	 *
	 * @param PathVariable string name of Quiz
	 * @return a random question
	 * @throws QuizNotFound 
	 */
	@GetMapping("quiz/{quizName}/random")
	public Question getRandomQuestion(@PathVariable("quizName") String quizName) throws QuizNotFound {
		return this.quizService.getRandomQuestion(quizName);
	}

	/**
	 * Add a question to the specified quiz
	 *
	 * @param PathVariable string quizName, Request BodyQuestion question
	 * @return the altered Quiz
	 * @throws QuestionAlreadyExists, QuizNotFound 
	 */
	@PatchMapping("quiz/{quizName}/add")
	public Quiz addQuestion(@PathVariable("quizName") String quizName, @RequestBody Question question) throws QuizNotFound, QuestionAlreadyExists {
		return this.quizService.addQuestion(quizName, question);
	}

	/**
	 * Delete a question from a quiz
	 *
	 * @param PathVariable string name of Quiz, PathVariable string name of question
	 * @return the deleted question
	 * @throws QuizNotFound, QuestionNotFound 
	 */
	@DeleteMapping("quiz/{quizName}/delete/{question}")
	public Question deleteQuestion(@PathVariable("quizName") String quizName,
			@PathVariable("question") String question) throws QuizNotFound, QuestionNotFound {
		return this.quizService.deleteQuestion(quizName, question);
	}

	/**
	 * Get a grade
	 *
	 * @param Quiz
	 * @return return a float of the grade
	 * @throws QuizNotFound 
	 */
	@PostMapping("quiz/grade")
	public float getGrade(@RequestBody Quiz quiz) throws QuizNotFound {
		return this.quizService.getGrade(quiz);
	}
}
