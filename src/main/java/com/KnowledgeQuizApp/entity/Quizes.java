/**
* 
* @Description Entity for holding All Quiz data 
* @author Mritunjay Yadav
* @Type Entity 
*
*/
package com.KnowledgeQuizApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="quizes")
public class Quizes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long quizid;
	
	//userone configurations
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private UserStuff userone;
	
	
	@Column(name="rightansuserone")
	private int rightansbyuserone;
	
	@Column(name="totaltimeuserone")
	private double totaltimeuserone;
	
	
	@Column(name="scoreuserone")
	private double scoreFromuserone;
	
	//usertwo configurations
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private UserStuff usertwo;
	
	@Column(name="totaltimeusertwo")
	private double totaltimeusertwo;
	
	@Column(name="rightansusertwo")
	private int rightansbyusertwo;
	
	
	@Column(name="scoreusertwo")
	private double scoreFromusertwo;
	
	@OneToMany(mappedBy="quizid")
	private List<Question> listOfQuestions;
	
	
	@OneToOne
	private UserStuff result;


	public long getQuizid() {
		return quizid;
	}


	public void setQuizid(long quizid) {
		this.quizid = quizid;
	}


	public UserStuff getUserone() {
		return userone;
	}


	public void setUserone(UserStuff userone) {
		this.userone = userone;
	}


	public int getRightansbyuserone() {
		return rightansbyuserone;
	}


	public void setRightansbyuserone(int rightansbyuserone) {
		this.rightansbyuserone = rightansbyuserone;
	}


	public double getTotaltimeuserone() {
		return totaltimeuserone;
	}


	public void setTotaltimeuserone(double totaltimeuserone) {
		this.totaltimeuserone = totaltimeuserone;
	}


	public double getScoreFromuserone() {
		return scoreFromuserone;
	}


	public void setScoreFromuserone(double scoreFromuserone) {
		this.scoreFromuserone = scoreFromuserone;
	}


	public UserStuff getUsertwo() {
		return usertwo;
	}


	public void setUsertwo(UserStuff usertwo) {
		this.usertwo = usertwo;
	}


	public double getTotaltimeusertwo() {
		return totaltimeusertwo;
	}


	public void setTotaltimeusertwo(double totaltimeusertwo) {
		this.totaltimeusertwo = totaltimeusertwo;
	}


	public int getRightansbyusertwo() {
		return rightansbyusertwo;
	}


	public void setRightansbyusertwo(int rightansbyusertwo) {
		this.rightansbyusertwo = rightansbyusertwo;
	}


	public double getScoreFromusertwo() {
		return scoreFromusertwo;
	}


	public void setScoreFromusertwo(double scoreFromusertwo) {
		this.scoreFromusertwo = scoreFromusertwo;
	}


	public List<Question> getListOfQuestions() {
		return listOfQuestions;
	}


	public void setListOfQuestions(List<Question> listOfQuestions) {
		this.listOfQuestions = listOfQuestions;
	}


	public UserStuff getResult() {
		return result;
	}


	public void setResult(UserStuff result) {
		this.result = result;
	}
	
	
}
