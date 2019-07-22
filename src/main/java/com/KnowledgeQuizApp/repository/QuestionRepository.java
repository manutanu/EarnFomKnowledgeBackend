/**
* 
* @Description Repository to interact with database and fetch Question details
* @author Mritunjay Yadav
* @Type Repository
*
*/
package com.KnowledgeQuizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KnowledgeQuizApp.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

}
