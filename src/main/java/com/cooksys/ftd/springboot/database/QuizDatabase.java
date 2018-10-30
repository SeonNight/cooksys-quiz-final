package com.cooksys.ftd.springboot.database;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.cooksys.ftd.springboot.entity.Question;
import com.cooksys.ftd.springboot.entity.Quiz;

//This is a pseudo database that do what databases do
public class QuizDatabase {
	Set<Quiz> quizes;

	public QuizDatabase() {
		quizes = new HashSet<Quiz>();
	}

	public QuizDatabase(Set<Quiz> quizes) {
		this.quizes = quizes;
	}

	/**
	 * Get all the quizes
	 * 
	 * @param none
	 * @return List of quizes
	 */
	public Set<Quiz> select() {
		return this.quizes;
	}

	/**
	 * Get quiz by quiz name
	 *
	 * @param name of quiz
	 * @return Quiz
	 */
	public Quiz select(String quizName) {
		for (Quiz quiz : quizes) {
			if (quiz.getName().equalsIgnoreCase(quizName)) {
				return quiz;
			}
		}
		return null;
	}

	/**
	 * Insert a quiz
	 *
	 * @param Quiz object
	 * @return none
	 */
	public void insert(Quiz quiz) {
		if (select(quiz.getName()) == null) {
			quizes.add(quiz);
		}
	}

	/**
	 * Insert a question into a quiz
	 *
	 * @param string name of Quiz, Question object
	 * @return none
	 */
	public void insert(String quizname, Question question) {
		Quiz quiz = select(quizname);
		if (quiz != null) {
			for (Question quest : quiz.getQuestions()) {
				if (quest.getQuestion().equalsIgnoreCase(question.getQuestion())) {
					return;
				}
			}
			quiz.getQuestions().add(question);
		}
	}

	/**
	 * Delete a quiz
	 *
	 * @param string name of Quiz
	 * @return none
	 */
	public void delete(String quizName) {
		for (Iterator<Quiz> iterator = quizes.iterator(); iterator.hasNext();) {
			Quiz s = iterator.next();
			if (s.getName().equals(quizName)) {
				iterator.remove();
			}
		}
	}

	/**
	 * Delete a question from a quiz
	 *
	 * @param string name of Quiz, string name of question
	 * @return none
	 */
	public void delete(String quizName, String questionText) {
		for (Quiz quiz : quizes) {
			if (quiz.getName().equals(quizName)) {
				for (Iterator<Question> iterator = quiz.getQuestions().iterator(); iterator.hasNext();) {
					Question s = iterator.next();
					if (s.getQuestion().equals(questionText)) {
						iterator.remove();
						return;
					}
				}
			}
		}
	}

	public void update(String quizName, String newName) {
		for (Quiz quiz : quizes) {
			if (quiz.getName().equalsIgnoreCase(quizName)) {
				quiz.setName(newName);
			}
		}
	}

	public Set<Quiz> getQuizes() {
		return quizes;
	}

	public void setQuizes(Set<Quiz> quizes) {
		this.quizes = quizes;
	}
}
