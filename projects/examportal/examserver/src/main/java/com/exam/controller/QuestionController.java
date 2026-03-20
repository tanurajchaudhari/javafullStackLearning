package com.exam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	//add question
	@PostMapping("/")
	public ResponseEntity<Question> add(@RequestBody Question question){
		return ResponseEntity.ok(questionService.addQuestion(question));
	}
	//update the question
	@PutMapping("/")
	public ResponseEntity<Question>update(@RequestBody Question question){
		return ResponseEntity.ok(questionService.updateQuestion(question));
	}

	//get all questions of any quiz for test (user)
	
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid")Long qid){
		Quiz quiz = quizService.getQuiz(qid);
		Set<Question> questions = quiz.getQuestions();
		List <Question>list=new ArrayList(questions);
		
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())) {
			 list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
		}
		list.forEach((q)->{
			q.setAnswer("");
		});
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	// get all questions of quiz for admin
	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid")Long qid){
		Quiz quiz = quizService.getQuiz(qid);
		Set<Question> questions = quiz.getQuestions();
		List list=new ArrayList(questions);
		
		
		return ResponseEntity.ok(list);
	}
	
	
	//get single question
	@GetMapping("/{quesId}")
	public Question get(@PathVariable("quesId")Long quesId) {
		return questionService.getQuestion(quesId);
	}
	//delete question
	@DeleteMapping("/{quesId}")
	public void delete(@PathVariable("quesId")Long quesId) {
		questionService.deleteQuestion(quesId);
	}
	
	//eval quiz
	@PostMapping("/eval-quiz")
	public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
		double marksGot=0;
		int correctAnswer=0;
		int attempted=0;
		
		System.out.println(questions);
		for(Question  q :  questions){
			System.err.println("backend givenanswers");
			System.out.println(q.getGivenAnswer());
			
			//single question
			Question question=this.questionService.get(q.getQuesId());
			if(question.getAnswer().equals(q.getGivenAnswer())){
				//correct 
				correctAnswer++;
				Double marksSingle=Double.parseDouble(questions.get(0).getQuiz().getMaxmarks())/ (questions.size());
			    marksGot +=marksSingle;
			    System.err.println(marksGot);
			}
			if(q.getGivenAnswer()!=null ) {
				attempted++;
			}
			
		}
		Map<String,Object> map=Map.of("marksGot",marksGot,"correctAnswer",correctAnswer,"attempted",attempted);
		return ResponseEntity.ok(map);
	}
}
