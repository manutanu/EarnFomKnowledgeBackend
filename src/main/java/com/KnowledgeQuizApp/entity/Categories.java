/**
* 
* @Description Entity for holding all Categories of Leagues
* @author Mritunjay Yadav
* @Type Entity 
*
*/

package com.KnowledgeQuizApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categories {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long categoryid;
	
	@Column(name="categoryName")
	private String categoryName;

	

	public long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
	
}
