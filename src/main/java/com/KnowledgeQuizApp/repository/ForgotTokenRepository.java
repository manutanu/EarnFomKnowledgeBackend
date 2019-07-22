/**
* 
* @Description Repository to interact with database and fetch Token for forgot password 
* @author Mritunjay Yadav
* @Type Repository
*
*/
package com.KnowledgeQuizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KnowledgeQuizApp.entity.ForgotPasswordToken;

@Repository
public interface ForgotTokenRepository extends JpaRepository<ForgotPasswordToken, Long> {

}
