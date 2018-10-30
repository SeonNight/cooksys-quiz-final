package com.cooksys.ftd.springboot.database;

import java.util.List;

import com.cooksys.ftd.springboot.entity.Question;
import com.cooksys.ftd.springboot.entity.Quiz;

//This is a pseudo database that do what databases do
public class QuizDatabase {
	List<Quiz> quizes;

	public QuizDatabase() {
	}

	public QuizDatabase(List<Quiz> quizes) {
		this.quizes = quizes;
	}

	/**
	 * Get all the quizes
	 * 
	 * @param none
	 * @return List of quizes
	 */
	public List<Quiz> select() {
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
		for (int i = 0; i < quizes.size(); i++) {
			if (quizes.get(i).getName().equalsIgnoreCase(quizName)) {
				quizes.remove(i);
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
		for (int i = 0; i < quizes.size(); i++) {
			if (quizes.get(i).getName().equalsIgnoreCase(quizName)) {
				for (int n = 0; n < quizes.get(i).getQuestions().size(); n++) {
					if (quizes.get(i).getQuestions().get(n).getQuestion().equalsIgnoreCase(questionText)) {
						quizes.get(i).getQuestions().remove(n);
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

	public List<Quiz> getQuizes() {
		return quizes;
	}

	public void setQuizes(List<Quiz> quizes) {
		this.quizes = quizes;
	}
}
