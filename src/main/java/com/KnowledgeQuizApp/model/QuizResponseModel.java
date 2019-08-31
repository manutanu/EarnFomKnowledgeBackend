package com.KnowledgeQuizApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.KnowledgeQuizApp.entity.LeagueTypes;
import com.KnowledgeQuizApp.entity.Question;
import com.KnowledgeQuizApp.entity.UserStuff;

public class QuizResponseModel {

	private long quizid;
	
	
	//userone configurations
	private UserStuff userone;
	
	
	
	private int rightansbyuserone;
	
	
	private double totaltimeuserone;
	
	
	
	private double scoreFromuserone;
	
	//usertwo configurations
	private UserStuff usertwo;
	

	private double totaltimeusertwo;
	
	
	private int rightansbyusertwo;
	
	
	
	private double scoreFromusertwo;
	
	
	private List<Question> listOfQuestions;
	
	
	
	private UserStuff result;
	
	
	private String status;
	
	
	private LeagueTypes leagueType;
	


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public LeagueTypes getLeagueType() {
		return leagueType;
	}


	public void setLeagueType(LeagueTypes leagueType) {
		this.leagueType = leagueType;
	}


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
