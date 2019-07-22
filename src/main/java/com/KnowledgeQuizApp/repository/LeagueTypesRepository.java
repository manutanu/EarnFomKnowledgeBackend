/**
* 
* @Description Repository to interact with database and fetch Types of Leagues
* @author Mritunjay Yadav
* @Type Repository
*
*/
package com.KnowledgeQuizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KnowledgeQuizApp.entity.LeagueTypes;

@Repository
public interface LeagueTypesRepository extends JpaRepository<LeagueTypes, Long> {

}
