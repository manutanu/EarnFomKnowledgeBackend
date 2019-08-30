package com.KnowledgeQuizApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KnowledgeQuizApp.model.CategoriesList;
import com.KnowledgeQuizApp.service.CategoriesService;

@RestController
@CrossOrigin({"*"})
public class CategoriesController {

	@Autowired
	public CategoriesService categoriesService; 
	
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/allcategories")
	public CategoriesList getAllCategories(){
		System.out.println("here inside categories folder ");
		return categoriesService.getAllCategories();
	}
	
}
