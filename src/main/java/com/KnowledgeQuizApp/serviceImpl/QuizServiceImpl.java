package com.KnowledgeQuizApp.serviceImpl;

import javax.swing.Spring;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KnowledgeQuizApp.constants.ConstantUtils;
import com.KnowledgeQuizApp.entity.QuizRequests;
import com.KnowledgeQuizApp.entity.UserStuff;
import com.KnowledgeQuizApp.model.QuizRequestModel;
import com.KnowledgeQuizApp.repository.QuizRepository;
import com.KnowledgeQuizApp.repository.QuizRequestRepository;
import com.KnowledgeQuizApp.repository.UserRepository;
import com.KnowledgeQuizApp.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService,ConstantUtils{

	@Autowired
	public QuizRepository quizRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public QuizRequestRepository quizRequestRepository;
	
	@Override
	public String generateQuiz(QuizRequestModel quizRequest) {
		
		//retrieve User object from database using usernames
		UserStuff whoshared = userRepository.findByUsernameAndActivated(quizRequest.getWhosharedid(),ACTIVATED);
		UserStuff towhomeshared = userRepository.findByUsernameAndActivated(quizRequest.getTowhomesharedid(),ACTIVATED);
		quizRequest.setWhoshared(whoshared);
		quizRequest.setTowhomeshared(towhomeshared);
		
		//create Quiz reqeust in the database 
		QuizRequests quizRequestEntity = new QuizRequests();
		BeanUtils.copyProperties(quizRequest,quizRequestEntity);
		quizRequestRepository.save(quizRequestEntity);
		
		//now generate Quiz for this request
		
		
		return null;
	}

}
