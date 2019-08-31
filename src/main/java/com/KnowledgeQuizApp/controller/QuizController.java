package com.KnowledgeQuizApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KnowledgeQuizApp.model.QuizRequestModel;
import com.KnowledgeQuizApp.model.QuizResponseModel;
import com.KnowledgeQuizApp.repository.QuizRepository;
import com.KnowledgeQuizApp.service.QuizService;

@RestController
@CrossOrigin({"*"})
public class QuizController {
	
	@Autowired
	public QuizService quizService;
	
	
	
	@PreAuthorize("hasAnyRole('USER')")
	@PostMapping("/createQuiz")
	public long createQuiz(@RequestBody QuizRequestModel quizRequest) {
		
		//create Quiz Request in database and then generate quiz and return quiz id to ui
		long id = quizService.generateQuiz(quizRequest);
		
		return id;
		
	}
	
	
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/fetchquizdata/{quizid}/{username}")
	public QuizResponseModel fetchQuizData(@PathVariable long quizid , @PathVariable String username) {
		
		//check which user is coming to play firstone or the secondone and reduce money from the wallet of the user 
		
		
		System.out.println(quizid +"  here i got quiz id back walla !");
		
		return quizService.fetchQuizDetails(quizid) ;
		
	}
	
	
	@PreAuthorize("hasAnyRole('USER')")
	@PostMapping("/processquiz")
	public Object processQuizResults() {
		
		return null;
	}
	
	
	
	
	
	
	
}
