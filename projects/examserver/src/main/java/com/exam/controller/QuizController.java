package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.exam.Quiz;
import com.exam.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;
	
	//add quiz service
	@PostMapping("/")
	public ResponseEntity<Quiz> add(@RequestBody Quiz quiz){
		return ResponseEntity.ok(quizService.addQuiz(quiz));
	}
	//update Quiz
	@PutMapping("/")
	public ResponseEntity<Quiz>update(@RequestBody Quiz quiz){
		return ResponseEntity.ok(quizService.updateQuiz(quiz));
	}
	
	//get quiz
	@GetMapping("/")
	public ResponseEntity<?>quizess(){
		return ResponseEntity.ok(quizService.getQuizess());
	}
	
	//get single quiz
	@GetMapping("/{qid}")
	public Quiz quizz(@PathVariable("qid")Long qid) {
		return quizService.getQuiz(qid);
	}
	
	//delete the quiz
	@DeleteMapping("/{qid}")
	public void delete(@PathVariable("qid") Long qid) {
		quizService.deleteQuiz(qid);
	}
	

}
