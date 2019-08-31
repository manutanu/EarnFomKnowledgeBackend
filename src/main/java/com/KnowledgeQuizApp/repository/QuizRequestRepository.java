package com.KnowledgeQuizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KnowledgeQuizApp.entity.QuizRequests;
import com.sun.mail.imap.protocol.ID;

@Repository
public interface QuizRequestRepository extends JpaRepository<QuizRequests, Long>{

	
}
