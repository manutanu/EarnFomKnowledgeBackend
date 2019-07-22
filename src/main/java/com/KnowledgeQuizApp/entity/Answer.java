/**
* 
* @Description Entity for holding Answers for questions
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
@Table(name="answer")
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long answerid;
	
	@Column(name="optionone")
	private String optionone;
	
	@Column(name="optiontwo")
	private String optiontwo;
	
	@Column(name="optionthree")
	private String optionthree;
	
	@Column(name="optionfour")
	private String optionfour;
	
	@Column(name="rightoption")
	private String rightoption;
	

	public long getAnswerid() {
		return answerid;
	}

	public void setAnswerid(long answerid) {
		this.answerid = answerid;
	}

	public String getOptionone() {
		return optionone;
	}

	public void setOptionone(String optionone) {
		this.optionone = optionone;
	}

	public String getOptiontwo() {
		return optiontwo;
	}

	public void setOptiontwo(String optiontwo) {
		this.optiontwo = optiontwo;
	}

	public String getOptionthree() {
		return optionthree;
	}

	public void setOptionthree(String optionthree) {
		this.optionthree = optionthree;
	}

	public String getOptionfour() {
		return optionfour;
	}

	public void setOptionfour(String optionfour) {
		this.optionfour = optionfour;
	}

	public String getRightoption() {
		return rightoption;
	}

	public void setRightoption(String rightoption) {
		this.rightoption = rightoption;
	}
	
	
	
	
}
