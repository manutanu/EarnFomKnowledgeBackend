/**
* 
* @Description Entity for holding Question Details
* @author Mritunjay Yadav
* @Type Entity 
*
*/
package com.KnowledgeQuizApp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long questionid;
	
	@OneToOne
	private Answer options;
	
	@ManyToOne
	private Quizes quizid;
	
	@Column(name="creationDate")
	private Date creationDate;
	
	@Column(name="usedDate")
	private Date usedDate;
	
	@Column(name="timeinseconds")
	private int timeinsecods;
	
	@Column(name="level")
	private String level;
	
	@OneToOne
	private Categories category;
	
	@PrePersist
	public void setDateOfcreation() {
		this.creationDate=new Date();
	}

	@PreUpdate
	public void setUsedDate() {
		this.usedDate=new Date();
	}
	
	public long getQuestionid() {
		return questionid;
	}

	public void setQuestionid(long questionid) {
		this.questionid = questionid;
	}

	public Answer getOptions() {
		return options;
	}

	public void setOptions(Answer options) {
		this.options = options;
	}

	public Quizes getQuizid() {
		return quizid;
	}

	public void setQuizid(Quizes quizid) {
		this.quizid = quizid;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUsedDate() {
		return usedDate;
	}

	public void setUsedDate(Date usedDate) {
		this.usedDate = usedDate;
	}

	public int getTimeinsecods() {
		return timeinsecods;
	}

	public void setTimeinsecods(int timeinsecods) {
		this.timeinsecods = timeinsecods;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}
	
	
	
}
