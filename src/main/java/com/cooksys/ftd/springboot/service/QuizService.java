package com.cooksys.ftd.springboot.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.ftd.springboot.entity.Question;
import com.cooksys.ftd.springboot.entity.Quiz;
import com.cooksys.ftd.springboot.exception.QuestionAlreadyExists;
import com.cooksys.ftd.springboot.exception.QuestionNotFound;
import com.cooksys.ftd.springboot.exception.QuizAlreadyExists;
import com.cooksys.ftd.springboot.exception.QuizNotFound;
import com.cooksys.ftd.springboot.repository.QuizRepository;

//Throws new exceptions
@Service
public class QuizService {
	QuizRepository quizRepository;
	
	@Autowired
	public QuizService(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}
	
	/**
	 * Get a Collection of Quizzes
	 *
	 * @param none
	 * @return a collection of Quizzes
	 * @throws QuizNotFound 
	 */
	public List<Quiz> getQuizzes() throws QuizNotFound {
		List<Quiz> quizzes = quizRepository.getQuizzes();
		if(quizzes != null) {
			return quizzes;
		}
		throw new QuizNotFound();
	}

	/**
	 * Add a quiz
	 *
	 * @param Quiz
	 * @return the quiz that was added
	 * @throws QuizAlreadyExists
	 */
	public Quiz addQuiz(Quiz quiz) throws QuizAlreadyExists {
		Quiz q = quizRepository.addQuiz(quiz);
		if(q != null) {
			return q;
		}
		throw new QuizAlreadyExists();
	}

	/**
	 * Delete a quiz given the name
	 *
	 * @param string name of Quiz
	 * @return the quiz that was deleted
	 * @throws QuizNotFound
	 */
	public Quiz deleteQuiz(String quizName) throws QuizNotFound {
		Quiz q = quizRepository.deleteQuiz(quizName);
		if(q != null) {
			return q;
		}
		throw new QuizNotFound();
	}

	/**
	 * Rename a quiz
	 *
	 * @param string name of Quiz, string new name
	 * @return the quiz that was altered
	 * @throws QuizNotFound
	 */
	public Quiz renameQuiz(String quizName, String newName) throws QuizNotFound {
		Quiz q = quizRepository.renameQuiz(quizName, newName);
		if(q != null) {
			return q;
		}
		throw new QuizNotFound();
	}

	/**
	 * Get a random question from the specified quiz
	 *
	 * @param string name of Quiz
	 * @return a random question
	 * @throws QuizNotFound
	 */
	public Question getRandomQuestion(String quizName) throws QuizNotFound {
		Quiz q = quizRepository.getQuiz(quizName);
		if(q == null) {
			throw new QuizNotFound();
		}
		Random rand = new Random();
		return q.getQuestions().get(rand.nextInt(q.getQuestions().size()));
	}

	/**
	 * Add a question to the specified quiz
	 *
	 * @param string quizName, question
	 * @return the altered Quiz
	 * @throws QuizNotFound, QuestionAlreadyExists
	 */
	public Quiz addQuestion(String quizName, Question question) throws QuizNotFound, QuestionAlreadyExists {
		Quiz q = quizRepository.addQuestion(quizName, question);
		if(q != null) {
			return q;
		}
		throw new QuizNotFound();
	}

	/**
	 * Delete a question from a quiz
	 *
	 * @param string name of Quiz, string name of question
	 * @return the deleted question
	 * @throws QuizNotFound, QuestionNotFound
	 */
	public Question deleteQuestion(String quizName, String questionText) throws QuizNotFound, QuestionNotFound {
		Question q = quizRepository.deleteQuestion(quizName, questionText);
		if(q != null) {
			return q;
		}
		throw new QuizNotFound();
	}

	/**
	 * Get a grade
	 *
	 * @param Quiz
	 * @return return a float of the grade
	 */
	public float getGrade(Quiz quiz) {
		return quizRepository.getGrade(quiz);
	}
}
