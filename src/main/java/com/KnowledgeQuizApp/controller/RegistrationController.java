/**
* RegistrationController
* This Class is controller for all apis related to registration and verification of Users
*
* 1.0
*
* @authored by Mritunjay Yadav
*/

package com.KnowledgeQuizApp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KnowledgeQuizApp.constants.ConstantUtils;
import com.KnowledgeQuizApp.entity.Role;
import com.KnowledgeQuizApp.entity.UserStuff;
import com.KnowledgeQuizApp.repository.RoleRepository;
import com.KnowledgeQuizApp.repository.UserRepository;


@ControllerAdvice
@RestController
@CrossOrigin({ "http://localhost:4100", "http://localhost:4200" ,"http://192.168.1.106:4200","*"})
public class RegistrationController implements ConstantUtils {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	/**
	 * @Description  controller for registering user with the website
	 * 
	 * @Author Mritunjay Yadav
	 * @return Map<Object,Object>
	 * @param UserStuff object
	 * @Exception 
	 * 
	 * */
	@PostMapping("/register")
	public String registerUser(@RequestBody UserStuff user) {
		Role r=roleRepository.getOne(1);
		ArrayList<Role> rolelist=new ArrayList<>();
		rolelist.add(r);
		user.setRoles(rolelist);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "success";
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/getmessage")
	public String getMessage() {
		return "Hellow Message";
	}
	
	/**
	 * @Description  Controller for verifying the user 
	 * 
	 * @Author Mritunjay Yadav
	 * @return String
	 * @param String VerificationToken
	 * @Exception 
	 * 
	 * */
	
	/*
	 * @GetMapping("/verification/{verificationtoken}") public String
	 * verifyUser(@PathVariable String verificationtoken) {
	 * 
	 * return registrationService.verificationUtility(verificationtoken);
	 * 
	 * }
	 */

}
