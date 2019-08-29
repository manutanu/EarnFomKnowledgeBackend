/*
* RegistrationServiceImpl
* This class Contains  method implementation for registration controller
*
* 1.0
*
* @authored by Mritunjay Yadav
*/

package com.KnowledgeQuizApp.serviceImpl;

import java.net.InetAddress;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSendException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.KnowledgeQuizApp.constants.ConstantUtils;
import com.KnowledgeQuizApp.entity.Role;
import com.KnowledgeQuizApp.entity.UserStuff;
import com.KnowledgeQuizApp.entity.VerificationToken;
import com.KnowledgeQuizApp.repository.RoleRepository;
import com.KnowledgeQuizApp.repository.UserRepository;
import com.KnowledgeQuizApp.repository.VerificationTokenRepository;
import com.KnowledgeQuizApp.service.MailSendingService;
import com.KnowledgeQuizApp.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService, ConstantUtils {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MailSendingService mailSendingService;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Value("${VERIFICATION_TOKEN_EXPIRATION}")
	private String expirationOfToken;
	
	@Autowired
	private RoleRepository roleRepository;

	
	/**
	 * @Description utility for verifying that verification token is valid and not expired 
	 * 
	 * @Author Mritunjay Yadav
	 * @return String
	 * @param String VerificationToken
	 * @Exception 
	 * 
	 */
	public String verificationUtility(String verificationToken) {

		try {
			
			//check verifcation token present or not 
			if (!StringUtils.isEmpty(verificationToken)) {
				
				//fetch the object from the database using token string and also fetch user object corresponding to verificationToken object
				VerificationToken tokenObj = verificationTokenRepository.findByToken(verificationToken);
				UserStuff user = tokenObj.getUserid();
				Calendar cal = Calendar.getInstance();

				//check if token is expired or not 
				if ((tokenObj.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
					
					verificationTokenRepository.delete(tokenObj);
					userRepository.delete(user);
					return "bad User or User Verification Link is expired please register again";
				
				}
				
				//else send response verified !!
				user.setActivated(ACTIVATED);
				userRepository.save(user);
				return "User verification SuccessFull ! Please Login to your account ";
			
			} else {

				//send this when no verification token is present
				return " bad VerificationToken ";

			}
		
		} catch (Exception e) {
			
			// TODO Custom EXception class for bad VerificationToken
			return " bad VerificationToken ";
		
		}
	
	}

	
	/**
	 * @Description registration controller utility method which registers user ,
	 *              generate verification link and send it to the user email
	 * 
	 * @Author Mritunjay Yadav
	 * @return Map<Object, Object >
	 * @param UserStuff object
	 * @Exception
	 * 
	 */
	@Transactional
	public Map<Object, Object> registrationUtility(UserStuff user,HttpServletRequest request) {

		Map<Object, Object> responseMap = new HashMap<>();
		VerificationToken verificationToken = new VerificationToken();
		System.out.println(user.getCompleteName()+" "+user.getPassword() + " " + user.getUsername() + " " + encoder.encode(user.getPassword()));

		// fetching details from registration call and encrypting user password
		user.setPassword(encoder.encode(user.getPassword()));

		// fetching all users from database with given username and email with active
		// flag true if exist then send message for existing email and username
		UserStuff usernamecheck = userRepository.getUserByUsernameAndActivated(user.getUsername(), ACTIVATED);
		UserStuff useremailcheck = userRepository.getUserByEmailAndActivated(user.getEmail(), ACTIVATED);

		// setting newly added user object with verified as flase and save it into db
		user.setActivated(NOT_ACTIVATED);
		
		//setting roles for the users
		Role r = roleRepository.getOne(1);
		ArrayList<Role> rolelist = new ArrayList<>();
		rolelist.add(r);
		user.setRoles(rolelist);

		try {
			
			//if username and useremail is not already exist in the database 
			
			if (usernamecheck == null && useremailcheck == null) {

				//if username and useremail is unique then create user data in database
				
				userRepository.save(user);
				
				// Verification Token Generation Logic using UUID util class 
				
				verificationToken = new VerificationToken();
				String tokenString = UUID.randomUUID().toString();
				verificationToken.setToken(tokenString);
				verificationToken.setUserid(user);
				verificationToken.setExpiryDate(setExpiryDate());
				verificationTokenRepository.save(verificationToken);
				
				
				//sample code for domain name fetch 
				
				byte[] ipAddress = new byte[] {(byte)127, (byte)0, (byte)0, (byte)1 };
			    InetAddress address = InetAddress.getByAddress(ipAddress);
			    String hostnameCanonical = address.getCanonicalHostName();
			    System.out.println("======================>>>> "+hostnameCanonical+"     "+request.getPathInfo()+"  "+request.getRequestURL());
			    int index=request.getRequestURL().indexOf("/register");
			    String actualpath = request.getRequestURL().substring(0,index+1);
			    System.out.println(actualpath);
			    
				
				//sample code end
				
				//message generation for verification mail sending logic 
			    String body ="";
			   // if(hostnameCanonical.equals("localhost"))
			    	//body = "Please click on this link to complete verification ==> http://localhost:5000/verification/"+ tokenString;
			    //else
			    	body = "Please click on this link to complete verification ==> "+actualpath+"verification/"+ tokenString;
			    
				
				//mail sending using service MailSendingService
				mailSendingService.sendMail(user.getEmail(), "Verification Mail From KnowldegeApp.com", body);

				//forming response for sending 
				
				responseMap.put("status", "SUCCESS");
				responseMap.put("userid", user.getUserid());
			
			} else if (usernamecheck != null) {
				
				//if username already exists in the database so delete just saved user in the database and send the response message
				//TODO Custom EXception class for UsernameAlreadyExists
				responseMap.put("status", "Username");
				responseMap.put("userid", -1);
			
			} else if (useremailcheck != null) {
				
				//if useremail already exists in the database so delete just saved user in the database and send the response message
				//TODO Custom EXception class for UserEmailAlreadyExists
				responseMap.put("status", "Useremail");
				responseMap.put("userid", -1);
			
			}
		
		} catch (MailSendException ex) {
			
			//throw exception message if mail couldnt sent through
			//TODO Custom EXception class for Email Cant be send right now  
			userRepository.delete(user);
			verificationTokenRepository.delete(verificationToken);
			ex.printStackTrace();
			responseMap.put("status", "ADDRESS");
		
		} catch (MailParseException ex) {
			
			//throw exception message if mail is not right 
			//TODO Custom EXception class for Email address does'nt exist
			userRepository.delete(user);
			verificationTokenRepository.delete(verificationToken);
			responseMap.put("status", "ADDRESS");
		
		} catch (Exception e) {
			
			//general exception
			//TODO Custom EXception class for InternalErrorException
			userRepository.delete(user);
			verificationTokenRepository.delete(verificationToken);
			responseMap.put("status", "ERROR");
		
		}
		
		//response map send
		return responseMap;
	
	}

	
	/**
	 * @Description utility method for setting expiry date for verificationToken
	 *              generated for the user after registration
	 * 
	 * @Author Mritunjay Yadav
	 * @return Date
	 * @param
	 * @Exception
	 * 
	 */
	public Date setExpiryDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Timestamp(cal.getTime().getTime()));
		System.out.println(expirationOfToken + " hserer ");
		cal.add(Calendar.MINUTE, Integer.parseInt(expirationOfToken));
		return new Date(cal.getTime().getTime());
	}

}
