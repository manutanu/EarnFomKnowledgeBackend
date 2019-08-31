package com.KnowledgeQuizApp.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KnowledgeQuizApp.constants.ConstantUtils;
import com.KnowledgeQuizApp.entity.Categories;
import com.KnowledgeQuizApp.entity.Question;
import com.KnowledgeQuizApp.entity.QuizRequests;
import com.KnowledgeQuizApp.entity.Quizes;
import com.KnowledgeQuizApp.entity.UserStuff;
import com.KnowledgeQuizApp.model.QuizRequestModel;
import com.KnowledgeQuizApp.model.QuizResponseModel;
import com.KnowledgeQuizApp.repository.CategoriesRepository;
import com.KnowledgeQuizApp.repository.LeagueTypesRepository;
import com.KnowledgeQuizApp.repository.QuestionRepository;
import com.KnowledgeQuizApp.repository.QuizRepository;
import com.KnowledgeQuizApp.repository.QuizRequestRepository;
import com.KnowledgeQuizApp.repository.UserRepository;
import com.KnowledgeQuizApp.service.QuizService;
import com.fasterxml.jackson.databind.util.BeanUtil;

@Service
public class QuizServiceImpl implements QuizService, ConstantUtils {

	@Autowired
	public QuizRepository quizRepository;

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public QuizRequestRepository quizRequestRepository;

	@Autowired
	public QuestionRepository questionRepository;

	@Autowired
	public CategoriesRepository categoriesRepository;
	
	@Autowired
	public LeagueTypesRepository leagueTypesRepository;

	@Override
	public long generateQuiz(QuizRequestModel quizRequest) {
		
		Quizes myquiz = new Quizes();
		long quizid = 0L;
		
		try {
			
			// retrieve User object from database using usernames
			UserStuff whoshared = userRepository.findByUsernameAndActivated(quizRequest.getWhosharedid(), ACTIVATED);
			UserStuff towhomeshared = userRepository.findByUsernameAndActivated(quizRequest.getTowhomesharedid(),ACTIVATED);
			quizRequest.setWhoshared(whoshared);
			quizRequest.setTowhomeshared(towhomeshared);

			// create Quiz reqeust in the database
			QuizRequests quizRequestEntity = new QuizRequests();
			BeanUtils.copyProperties(quizRequest, quizRequestEntity);
			quizRequestRepository.save(quizRequestEntity);
			
			// now generate Quiz for this request
			// fetch 10 questions for making Quiz
			Categories category = categoriesRepository.getCategoriesByCategoryName(quizRequest.getCategory());
			List<Question> listOfQuestions = questionRepository.findAllQuestionByCategory(category);
			
			myquiz.setLeagueType(leagueTypesRepository.getOne(quizRequest.getLeagueid()));
			myquiz.setListOfQuestions(listOfQuestions);
			myquiz.setStatus("P1");
			myquiz.setUserone(quizRequest.getWhoshared());
			myquiz.setUsertwo(quizRequest.getTowhomeshared());
			
			//save the quiz object and take the quizid
			myquiz = quizRepository.save(myquiz);
			quizid = myquiz.getQuizid();
			
			
			//System.out.println(myquiz);
			//TODO send mail to the opponent about quiz request 
			
			
			return quizid;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	
	@Override
	public QuizResponseModel fetchQuizDetails(long quizid) {
		
		QuizResponseModel quizdetails = new QuizResponseModel();
		BeanUtils.copyProperties(quizRepository.getOne(quizid),quizdetails);   
				
		return quizdetails;
	}

}
