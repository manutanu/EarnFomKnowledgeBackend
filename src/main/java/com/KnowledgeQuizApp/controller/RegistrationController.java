/**
* RegistrationController
* This Class is controller for all apis related to registration and verification of Users
*
* 1.0
*
* @authored by Mritunjay Yadav
*/

package com.KnowledgeQuizApp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KnowledgeQuizApp.constants.ConstantUtils;
import com.KnowledgeQuizApp.entity.UserStuff;
import com.KnowledgeQuizApp.repository.UserRepository;
import com.KnowledgeQuizApp.service.RegistrationService;

@ControllerAdvice
@RestController
@CrossOrigin({ "*" })
public class RegistrationController implements ConstantUtils {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RegistrationService registrationService;

	/**
	 * @Description controller for registering user with the website
	 * 
	 * @Author Mritunjay Yadav
	 * @return Map<Object,Object>
	 * @param UserStuff object
	 * @Exception
	 * 
	 */
	@PostMapping("/register")
	public Map<Object,Object> registerUser(@RequestBody UserStuff user, HttpServletRequest request) {

		Map<Object , Object> responseMap = registrationService.registrationUtility(user, request);
		return responseMap;
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/getmessage")
	public String getMessage() {
		return "Hellow Message";
	}

	
	/**
	 * @Description Controller for verifying the user
	 * 
	 * @Author Mritunjay Yadav
	 * @return String
	 * @param String VerificationToken
	 * @Exception
	 * 
	 */
	  @GetMapping("/verification/{verificationtoken}") public String
	  verifyUser(@PathVariable String verificationtoken) {
	  
	  return registrationService.verificationUtility(verificationtoken);
	  
	  }
	 

}
