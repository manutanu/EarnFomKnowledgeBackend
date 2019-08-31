package com.KnowledgeQuizApp.service;

import com.KnowledgeQuizApp.model.QuizRequestModel;
import com.KnowledgeQuizApp.model.QuizResponseModel;

public interface QuizService {

	public long generateQuiz(QuizRequestModel quizRequest);
	
	public QuizResponseModel fetchQuizDetails(long quizid);
}
