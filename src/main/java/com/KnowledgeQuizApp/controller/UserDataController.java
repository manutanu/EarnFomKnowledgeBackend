package com.KnowledgeQuizApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KnowledgeQuizApp.model.UsernameList;
import com.KnowledgeQuizApp.service.UserDetailService;

@RestController
@CrossOrigin({"*"})
public class UserDataController {

	@Autowired
	public UserDetailService userDetailServie;
	
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/getAllUsernames")
	public UsernameList getAllUsernames() {
		
		return userDetailServie.getAllUserNames();
	
	}
	
}
