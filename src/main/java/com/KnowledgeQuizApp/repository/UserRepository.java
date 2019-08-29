/**
* 
* @Description Repository to interact with database and fetch User details
* @author Mritunjay Yadav
* @Type Repository
*
*/
package com.KnowledgeQuizApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KnowledgeQuizApp.entity.UserStuff;

@Repository
public interface UserRepository extends JpaRepository<UserStuff, Long>{

	public UserStuff findByUsernameAndActivated(String username, int activated);

	public UserStuff getUserByUsernameAndActivated(String username,int verified);
	
	public UserStuff getUserByEmailAndActivated(String email,int verified);
	
	public UserStuff getUserByUseridAndActivated(long userid,int verified);
	
	public List<UserStuff> getAllUserByActivated(int verified);
	
	
	
}
