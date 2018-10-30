package com.cooksys.ftd.springboot.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cooksys.ftd.springboot.database.QuizDatabase;
import com.cooksys.ftd.springboot.entity.Question;
import com.cooksys.ftd.springboot.entity.Quiz;
import com.cooksys.ftd.springboot.exception.QuestionAlreadyExists;
import com.cooksys.ftd.springboot.exception.QuestionNotFound;

//This actually accesses the database
@Repository
public class QuizRepository {
	
	QuizDatabase quizDatabase;
	
	//'Connect' to database
	public QuizRepository() {
		this.quizDatabase = new QuizDatabase();
		this.quizDatabase.init();
	}

	/**
	 * Get a Collection of Quizzes
	 *
	 * @param none
	 * @return a collection of Quizzes
	 */
	public List<Quiz> getQuizzes() {
		List<Quiz> quizzes = quizDatabase.select();
		return quizzes;
	}
	
	/**
	 * Get a quiz
	 *
	 * @param name of quiz
	 * @return return quiz
	 */
	public Quiz getQuiz(String quizName) {
		return quizDatabase.select(quizName);
	}
	
	/**
	 * Add a quiz
	 *
	 * @param Quiz
	 * @return the quiz that was added or null
	 */
	public Quiz addQuiz(Quiz quiz){
		if(quizDatabase.select(quiz.getName()) == null) {
			quizDatabase.insert(quiz);
			return quizDatabase.select(quiz.getName());
		}
		return null;
	}

	/**
	 * Delete a quiz given the name
	 *
	 * @param string name of Quiz
	 * @return the quiz that was deleted or null
	 */
	public Quiz deleteQuiz(String quizName) {
		Quiz returnQuiz = quizDatabase.select(quizName);
		if(returnQuiz != null) {
			returnQuiz = new Quiz(returnQuiz.getName(), returnQuiz.getQuestions());
			quizDatabase.delete(quizName);
		}
		return returnQuiz;
	}

	/**
	 * Rename a quiz
	 *
	 * @param string name of Quiz, string new name
	 * @return the quiz that was altered or null
	 */
	public Quiz renameQuiz(String quizName, String newName) {
		Quiz returnQuiz = quizDatabase.select(quizName);
		if(returnQuiz != null) {
			returnQuiz.setName(newName);
		}
		return returnQuiz;
	}

	/**
	 * Add a question to the specified quiz
	 *
	 * @param string quizName, question
	 * @return the altered Quiz
	 * @throws QuestionAlreadyExists
	 */
	public Quiz addQuestion(String quizName, Question question) throws QuestionAlreadyExists {
		Quiz returnQuiz = getQuiz(quizName);
		if(returnQuiz != null) {
			for(Question ques: returnQuiz.getQuestions()) {
				if(ques.getQuestion().equalsIgnoreCase(question.getQuestion())) {
					throw new QuestionAlreadyExists();
				}
			}
			returnQuiz.getQuestions().add(question);
		}
		return returnQuiz;
	}

	/**
	 * Delete a question from a quiz
	 *
	 * @param string name of Quiz, string name of question
	 * @return the deleted question
	 * @throws QuestionNotFound
	 */
	public Question deleteQuestion(String quizName, String questionText) throws QuestionNotFound {
		Quiz returnQuiz = getQuiz(quizName);
		Question returnQuestion;
		if(returnQuiz != null) {
			for(Question ques: returnQuiz.getQuestions()) {
				if(ques.getQuestion().equalsIgnoreCase(questionText)) {
					returnQuestion = ques;
					quizDatabase.delete(quizName,questionText);
					return returnQuestion;
				}
			}
			throw new QuestionNotFound();
		}
		return null;
	}

	/**
	 * Get a grade
	 *
	 * @param Quiz
	 * @return return a float of the grade
	 */
	public float getGrade(Quiz quiz) {
		
		
		return 0f;
	}
}
