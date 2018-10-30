package com.cooksys.ftd.springboot;

import java.util.ArrayList;

import com.cooksys.ftd.springboot.database.QuizDatabase;
import com.cooksys.ftd.springboot.entity.*;

public class Test {
	public static void main(String[] args) {
		QuizDatabase quizDatabase = new QuizDatabase();
		quizDatabase.init();
		
		Answer a1 = new Answer("AAAAHHHHHHHHH",false);
		Question q1 = new Question("This is a QUESTION!", new ArrayList<Answer>());
		q1.getAnswers().add(a1);
		Quiz qu1 = new Quiz("Hello", new ArrayList<Question>());
		qu1.getQuestions().add(q1);

		System.out.println("---Insert---");
		quizDatabase.insert(qu1);
		
		for(Quiz quiz: quizDatabase.select()) {
			System.out.println("Q:" + quiz.getName());
			for(Question question: quiz.getQuestions()) {
				System.out.println(" q:" + question.getQuestion());
				for(Answer answer: question.getAnswers()) {
					System.out.println("   a:" + answer.getAnswer());
				}
			}
		}

		System.out.println("--Select--");
		
		Quiz quiz2 = quizDatabase.select("Quiz1");
		System.out.println("Q:" + quiz2.getName());
		for(Question question: quiz2.getQuestions()) {
			System.out.println(" q:" + question.getQuestion());
			for(Answer answer: question.getAnswers()) {
				System.out.println("   a:" + answer.getAnswer());
			}
		}
		
		
		System.out.println("---Delete---");
		
		quizDatabase.delete("Quiz1");
		
		for(Quiz quiz: quizDatabase.select()) {
			System.out.println("Q:" + quiz.getName());
			for(Question question: quiz.getQuestions()) {
				System.out.println(" q:" + question.getQuestion());
				for(Answer answer: question.getAnswers()) {
					System.out.println("   a:" + answer.getAnswer());
				}
			}
		}
		
		System.out.println("---Insert Question---");
		
		Question q2 = new Question("This is new Question", new ArrayList<Answer>());
		quizDatabase.insert("Hello",q2);
		
		for(Quiz quiz: quizDatabase.select()) {
			System.out.println("Q:" + quiz.getName());
			for(Question question: quiz.getQuestions()) {
				System.out.println(" q:" + question.getQuestion());
				for(Answer answer: question.getAnswers()) {
					System.out.println("   a:" + answer.getAnswer());
				}
			}
		}
		
		System.out.println("---Delete Question---");
		
		quizDatabase.delete("Hello", "This is a QUESTION!");
		
		for(Quiz quiz: quizDatabase.select()) {
			System.out.println("Q:" + quiz.getName());
			for(Question question: quiz.getQuestions()) {
				System.out.println(" q:" + question.getQuestion());
				for(Answer answer: question.getAnswers()) {
					System.out.println("   a:" + answer.getAnswer());
				}
			}
		}
		
		System.out.println("---Rename Quiz---");
		
		quizDatabase.update("Hello", "NOOOOO");
		
		for(Quiz quiz: quizDatabase.select()) {
			System.out.println("Q:" + quiz.getName());
			for(Question question: quiz.getQuestions()) {
				System.out.println(" q:" + question.getQuestion());
				for(Answer answer: question.getAnswers()) {
					System.out.println("   a:" + answer.getAnswer());
				}
			}
		}
	}
}
