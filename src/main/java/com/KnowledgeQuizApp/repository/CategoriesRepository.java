/**
* 
* @Description Repository to interact with database and fetch Categories 
* @author Mritunjay Yadav
* @Type Repository
*
*/
package com.KnowledgeQuizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KnowledgeQuizApp.entity.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long>{

}
