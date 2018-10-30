package com.cooksys.ftd.springboot.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.ftd.springboot.entity.Answer;
import com.cooksys.ftd.springboot.entity.Question;
import com.cooksys.ftd.springboot.entity.Quiz;
import com.cooksys.ftd.springboot.exception.DatabaseEmpty;
import com.cooksys.ftd.springboot.exception.QuestionAlreadyExists;
import com.cooksys.ftd.springboot.exception.QuestionNotFound;
import com.cooksys.ftd.springboot.exception.QuizAlreadyExists;
import com.cooksys.ftd.springboot.exception.QuizNotFound;
import com.cooksys.ftd.springboot.repository.QuizRepository;

//Buisness logic and throws exceptions
@Service
public class QuizService {
	QuizRepository quizRepository;

	@Autowired
	public QuizService(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}

	/**
	 * Does quiz Exist
	 *
	 * @param name of quiz
	 * @return true if it exists, false if it doesn't
	 */
	public boolean quizExists(String quizName) {
		return (quizRepository.getQuiz(quizName) != null);
	}

	/**
	 * Does question Exist
	 *
	 * @param name of quiz and name of question
	 * @return true if it exists, false if it doesn't
	 */
	public boolean questionExists(String quizName, String questionText) {
		for (Question q : quizRepository.getQuiz(quizName).getQuestions()) {
			if (q.getQuestion().equalsIgnoreCase(questionText)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get a Collection of Quizzes
	 *
	 * @param none
	 * @return a collection of Quizzes
	 * @throws DatabaseEmpty
	 */
	public List<Quiz> getQuizzes() throws DatabaseEmpty {
		List<Quiz> quizzes = quizRepository.getQuizzes();
		if (quizzes != null) {
			return quizzes;
		}
		throw new DatabaseEmpty();
	}

	/**
	 * Add a quiz
	 *
	 * @param Quiz
	 * @return the quiz that was added
	 * @throws QuizAlreadyExists
	 */
	public Quiz addQuiz(Quiz quiz) throws QuizAlreadyExists {
		if (quizExists(quiz.getName())) {
			throw new QuizAlreadyExists();
		}
		return quizRepository.addQuiz(quiz);
	}

	/**
	 * Delete a quiz given the name
	 *
	 * @param string name of Quiz
	 * @return the quiz that was deleted
	 * @throws QuizNotFound
	 */
	public Quiz deleteQuiz(String quizName) throws QuizNotFound {
		if (!quizExists(quizName)) {
			throw new QuizNotFound();
		}
		return quizRepository.deleteQuiz(quizName);
	}

	/**
	 * Rename a quiz
	 *
	 * @param string name of Quiz, string new name
	 * @return the quiz that was altered
	 * @throws QuizNotFound
	 */
	public Quiz renameQuiz(String quizName, String newName) throws QuizNotFound {
		if (!quizExists(quizName)) {
			throw new QuizNotFound();
		}
		return quizRepository.renameQuiz(quizName, quizName);
	}

	/**
	 * Get a random question from the specified quiz
	 *
	 * @param string name of Quiz
	 * @return a random question
	 * @throws QuizNotFound, QuestionNotFound
	 */
	public Question getRandomQuestion(String quizName) throws QuizNotFound, QuestionNotFound {
		if (!quizExists(quizName)) {
			throw new QuizNotFound();
		}
		Quiz q = quizRepository.getQuiz(quizName);
		if (q.getQuestions().isEmpty()) {
			throw new QuestionNotFound();
		}
		return q.getQuestions().get(new Random().nextInt(q.getQuestions().size()));
	}

	/**
	 * Add a question to the specified quiz
	 *
	 * @param string quizName, question
	 * @return the altered Quiz
	 * @throws QuizNotFound, QuestionAlreadyExists
	 */
	public Quiz addQuestion(String quizName, Question question) throws QuizNotFound, QuestionAlreadyExists {
		if (!quizExists(quizName)) {
			throw new QuizNotFound();
		}
		if (questionExists(quizName, question.getQuestion())) {
			throw new QuestionAlreadyExists();
		}
		return quizRepository.addQuestion(quizName, question);
	}

	/**
	 * Delete a question from a quiz
	 *
	 * @param string name of Quiz, string name of question
	 * @return the deleted question
	 * @throws QuizNotFound, QuestionNotFound
	 */
	public Question deleteQuestion(String quizName, String questionText) throws QuizNotFound, QuestionNotFound {
		if (!quizExists(quizName)) {
			throw new QuizNotFound();
		}
		if (!questionExists(quizName, questionText)) {
			throw new QuestionNotFound();
		}
		return quizRepository.deleteQuestion(quizName, questionText);
	}

	/**
	 * Get a grade
	 *
	 * @param Quiz
	 * @return return a float of the grade
	 */
	public float getGrade(Quiz quiz) {
		float numQuestions = 0;
		float numCorrectAns = 0;
		for (Question question : quiz.getQuestions()) {
			numQuestions++;
			for (Answer answer : question.getAnswers()) {
				if (answer.isCorrect()) {
					numCorrectAns++;
				}
			}
		}
		if (numQuestions == 0) {
			return 100f;
		}
		return (numCorrectAns / numQuestions) * 100;
	}
}
