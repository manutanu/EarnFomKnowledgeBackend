package com.KnowledgeQuizApp.model;


import java.util.Date;

import javax.persistence.Transient;

import com.KnowledgeQuizApp.entity.UserStuff;

public class QuizRequestModel {
	
	private String whosharedid;
	
	
	private String towhomesharedid;
	
	
	private UserStuff whoshared;
	
	
	private UserStuff towhomeshared;
	
	
	private Date timeofrequest;
	
	
	private Date timeoffullfilment;
	
	private String category;
	
	private long leagueid;
	

	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public UserStuff getWhoshared() {
		return whoshared;
	}

	public void setWhoshared(UserStuff whoshared) {
		this.whoshared = whoshared;
	}

	public UserStuff getTowhomeshared() {
		return towhomeshared;
	}

	public void setTowhomeshared(UserStuff towhomeshared) {
		this.towhomeshared = towhomeshared;
	}

	public Date getTimeofrequest() {
		return timeofrequest;
	}

	public void setTimeofrequest(Date timeofrequest) {
		this.timeofrequest = timeofrequest;
	}

	public Date getTimeoffullfilment() {
		return timeoffullfilment;
	}

	public void setTimeoffullfilment(Date timeoffullfilment) {
		this.timeoffullfilment = timeoffullfilment;
	}

	public String getWhosharedid() {
		return whosharedid;
	}

	public void setWhosharedid(String whosharedid) {
		this.whosharedid = whosharedid;
	}

	public String getTowhomesharedid() {
		return towhomesharedid;
	}

	public void setTowhomesharedid(String towhomesharedid) {
		this.towhomesharedid = towhomesharedid;
	}

	public long getLeagueid() {
		return leagueid;
	}

	public void setLeagueid(long leagueid) {
		this.leagueid = leagueid;
	}
	
	
	
}
