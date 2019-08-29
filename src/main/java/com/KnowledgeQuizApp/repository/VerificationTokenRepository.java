/**
* 
* @Description Repository to interact with database and fetch Verification Token related details
* @author Mritunjay Yadav
* @Type Repository
*
*/
package com.KnowledgeQuizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KnowledgeQuizApp.entity.VerificationToken;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

	public VerificationToken findByToken(String verificationToken);
}
