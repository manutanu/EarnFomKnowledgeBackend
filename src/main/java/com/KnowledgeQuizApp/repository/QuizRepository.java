/**
* 
* @Description Repository to interact with database and fetch quiz details 
* @author Mritunjay Yadav
* @Type Repository
*
*/
package com.KnowledgeQuizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KnowledgeQuizApp.entity.Quizes;

@Repository
public interface QuizRepository extends JpaRepository<Quizes, Long> {

}
