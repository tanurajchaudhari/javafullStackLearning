package com.exam.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.exam.Quiz;
import com.exam.repo.QuizRepository;
import com.exam.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepository quizRepository;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		
	  return quizRepository.save(quiz) ;
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return quizRepository.save(quiz) ;
	}

	@Override
	public Set<Quiz> getQuizess() {
		
		return new HashSet<>(quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		return quizRepository.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
//		Quiz quiz=new Quiz();
//		quiz.setQId(quizId);
//		quizRepository.delete(quiz);	
		
		quizRepository.deleteById(quizId);
		
		
	}
	
	

}
