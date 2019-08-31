package com.KnowledgeQuizApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KnowledgeQuizApp.model.QuizRequestModel;
import com.KnowledgeQuizApp.service.QuizService;

@RestController
@CrossOrigin({"*"})
public class QuizController {
	
	@Autowired
	public QuizService quizService;
	
	@PostMapping("/createQuiz")
	public Object createQuiz(@RequestBody QuizRequestModel quizRequest) {
		//create Quiz Request in database and then generate quiz and return quiz id to ui
		quizService.generateQuiz(quizRequest);
		return null;
	}
	
}
