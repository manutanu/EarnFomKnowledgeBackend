/*
* RegistrationService
* This Interface Contains to method signature for registration controller
*
* 1.0
*
* @authored by Mritunjay Yadav
*/

package com.KnowledgeQuizApp.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.KnowledgeQuizApp.entity.UserStuff;



public interface RegistrationService {
	
	public String verificationUtility(String username);
	
	public Map<Object,Object> registrationUtility(UserStuff user,HttpServletRequest request);

}
