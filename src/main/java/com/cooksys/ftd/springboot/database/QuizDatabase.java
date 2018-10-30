package com.cooksys.ftd.springboot.database;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.ftd.springboot.entity.*;

//This is a pseudo database
//Do what databases do
public class QuizDatabase {
	List<Quiz> quizes;

	public QuizDatabase() {
	}
	
	public QuizDatabase(List<Quiz> quizes) {
		this.quizes = quizes;
	}
	
	//Test Values
	public void init() {
		this.quizes = new ArrayList<Quiz>();
		Answer answer = new Answer("This is an answer",true);
		Question question = new Question("This is a question",new ArrayList<Answer>());
		Quiz quiz = new Quiz("Quiz1", new ArrayList<Question>());
		question.getAnswers().add(answer);
		quiz.getQuestions().add(question);
		this.quizes.add(quiz);
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
	
	public void insert(Quiz quiz) {
		if(select(quiz.getName()) == null) {
			quizes.add(quiz);
		}
	}
	public void insert(String quizname, Question question) {
		Quiz quiz = select(quizname);
		if(quiz != null) {
			for(Question quest: quiz.getQuestions()) {
				if(quest.getQuestion().equalsIgnoreCase(question.getQuestion())) {
					return;
				}
			}
			quiz.getQuestions().add(question);
		}
	}
	
	public void delete(String quizName) {
		for(int i = 0; i < quizes.size(); i++) {
			if(quizes.get(i).getName().equalsIgnoreCase(quizName)) {
				quizes.remove(i);
			}
		}
	}
	public void delete(String quizName, String questionText) {
		for(int i = 0; i < quizes.size(); i++) {
			if(quizes.get(i).getName().equalsIgnoreCase(quizName)) {
				for(int n = 0; n < quizes.get(i).getQuestions().size(); n++) {
					if(quizes.get(i).getQuestions().get(n).getQuestion().equalsIgnoreCase(questionText)) {
						quizes.get(i).getQuestions().remove(n);
					}
				}
			}
		}
	}

	public void update(String quizName, String newName) {
		for(Quiz quiz: quizes) {
			if(quiz.getName().equalsIgnoreCase(quizName)) {
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
