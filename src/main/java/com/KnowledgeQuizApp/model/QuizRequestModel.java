package com.KnowledgeQuizApp.model;


import java.util.Date;

import javax.persistence.Transient;

import com.KnowledgeQuizApp.entity.UserStuff;

public class QuizRequestModel {

	private long requestid;
	
	@Transient
	private String whosharedid;
	
	@Transient
	private String towhomesharedid;
	
	
	private UserStuff whoshared;
	
	
	private UserStuff towhomeshared;
	
	
	private Date timeofrequest;
	
	
	private Date timeoffullfilment;

	
	public long getRequestid() {
		return requestid;
	}

	public void setRequestid(long requestid) {
		this.requestid = requestid;
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
	
	
	
}
