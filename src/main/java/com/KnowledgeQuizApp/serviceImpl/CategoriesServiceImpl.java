package com.KnowledgeQuizApp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KnowledgeQuizApp.model.CategoriesList;
import com.KnowledgeQuizApp.repository.CategoriesRepository;
import com.KnowledgeQuizApp.service.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService{

	@Autowired
	public CategoriesRepository categoriesRepository;
	
	@Override
	public CategoriesList getAllCategories() {
		
		CategoriesList catList= new CategoriesList();
		catList.setListOfCategories(categoriesRepository.findAll());
		return catList;
		
	}
	
}
