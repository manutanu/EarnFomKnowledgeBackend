/*
* JwtUserDetailsService
*  This class contains a method which uses DB to authenticate User details 
*
* 1.0
*
* @authored by Mritunjay Yadav
*/


package com.KnowledgeQuizApp.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.KnowledgeQuizApp.constants.ConstantUtils;
import com.KnowledgeQuizApp.entity.Role;
import com.KnowledgeQuizApp.entity.UserStuff;
import com.KnowledgeQuizApp.repository.UserRepository;




@Service
public class JwtUserDetailsService implements UserDetailsService,ConstantUtils {

/*	@Autowired
*	private PasswordEncoder obj;
*/

	@Autowired
	private UserRepository userRepository;

	
	/**
	 * @Description  loadUserByUsername method from UserDetailsService is @Overrided
	 * 
	 * @Author Mritunjay Yadav
	 * @return UserDetails	
	 * @param String username
	 * @Exception UsernameNotFoundException
	 * 
	 * */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//fetching userobject from database using username and activated flag
		UserStuff userstuff = userRepository.findByUsernameAndActivated(username,ACTIVATED);

		if (userstuff!=null) {
			
			ArrayList<SimpleGrantedAuthority> authorityList=new ArrayList<>();
			for(Role r: userstuff.getRoles()) {
				authorityList.add(new SimpleGrantedAuthority("ROLE_"+r.getRole()));
			}
			//if userobject found in the database than return User object 
			return new User(userstuff.getUsername(), userstuff.getPassword(),authorityList);
		
		} else {
			
			//if not found throw UsernameNotFoundException
			throw new UsernameNotFoundException("User not found with username: " + username);
		
		}
		 
	}

}