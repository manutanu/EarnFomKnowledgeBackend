package com.KnowledgeQuizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KnowledgeQuizApp.entity.UserStuff;

@Repository
public interface UserRepository extends JpaRepository<UserStuff, Long>{

}
