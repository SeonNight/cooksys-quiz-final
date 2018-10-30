package com.cooksys.ftd.springboot.database;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.ftd.springboot.entity.Question;
import com.cooksys.ftd.springboot.entity.Quiz;

//This is a database
//Do what databases do
public class QuizDatabase {
	List<Quiz> quizes;

	public QuizDatabase() {
		quizes = new ArrayList<Quiz>();
	}
	public QuizDatabase(List<Quiz> quizes) {
		this.quizes = quizes;
	}

	public List<Quiz> select() {
		return this.quizes;
	}
	public Quiz select(String quizName) {
		for(Quiz quiz: quizes) {
			if(quiz.getName().equalsIgnoreCase(quizName)) {
				return quiz;
			}
		}
		return null;
	}
	
	public Quiz insert(Quiz quiz) {
		if(select(quiz.getName()) == null) {
			quizes.add(quiz);
			return quiz;
		}
		return null;
	}
	public Quiz insert(String quizname, Question question) {
		Quiz quiz = select(quizname);
		if(quiz != null) {
			for(Question quest: quiz.getQuestions()) {
				if(quest.getQuestion().equalsIgnoreCase(question.getQuestion())) {
					return null;
				}
			}
			quiz.getQuestions().add(question);
		}
		return quiz;
	}
	
	public Quiz delete(String quizName) {
		for(Quiz quiz: quizes) {
			if(quiz.getName().equalsIgnoreCase(quizName)) {
				return quiz;
			}
		}
		return null;
	}
	public Quiz delete(String quizName, String questionName) {
		return null;
	}

	public Quiz update(String quizName, String newName) {
		return null;
	}
	
	

	public List<Quiz> getQuizes() {
		return quizes;
	}

	public void setQuizes(List<Quiz> quizes) {
		this.quizes = quizes;
	}
}
