package com.KnowledgeQuizApp.serviceImpl;

import org.springframework.stereotype.Service;

import com.KnowledgeQuizApp.exceptions.TestException;
import com.KnowledgeQuizApp.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	
	@Override
	public void testMethod() throws TestException,Exception{
		Thread.sleep(2000);
		
//		return new TestException("Testing My Exception");
		throw new TestException("this is a bad request ");
	}

}
