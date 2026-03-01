package com.exam.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exam.entity.exam.Category;
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

	@Override
	public ResponseEntity<?> getQuizzesOfCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
	
		return quizRepository.findBycategory(category);
	}

	@Override
	public List<Quiz> getActiveQuizzes() {
		
		return  quizRepository.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizzesOfCategory(Category category) {

		return quizRepository.findByCategoryAndActive(category,true);
	}
	
	

}
