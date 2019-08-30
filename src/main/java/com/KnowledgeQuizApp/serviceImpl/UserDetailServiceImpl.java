package com.KnowledgeQuizApp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KnowledgeQuizApp.constants.ConstantUtils;
import com.KnowledgeQuizApp.entity.UserStuff;
import com.KnowledgeQuizApp.model.UsernameList;
import com.KnowledgeQuizApp.repository.UserRepository;
import com.KnowledgeQuizApp.service.UserDetailService;

@Service
public class UserDetailServiceImpl implements UserDetailService,ConstantUtils{
	
	@Autowired
	public UserRepository userRepository;
	
	@Override
	public UsernameList getAllUserNames() {
		
		UsernameList usernameobjList = new UsernameList();
		List<UserStuff> listOfuser= userRepository.getAllUserByActivated(ACTIVATED);
		List<String> usernameList=new ArrayList<>();
		
		for(int i=0;i<listOfuser.size();i++) {
			usernameList.add(listOfuser.get(i).getUsername());
			System.out.println(usernameList.get(i));
		}
		
		usernameobjList.setUsernameList(usernameList);
		return usernameobjList;
		
	}

	
}
