/*
* JwtResponse
*  This class acts as VO to hold data which is used in sending response for authentication api
*
* 1.0
*
* @authored by Mritunjay Yadav
*/

package com.KnowledgeQuizApp.model;

import java.io.Serializable;
import java.util.Date;

import com.KnowledgeQuizApp.entity.Wallet;

public class JwtResponse implements Serializable {

	private static long serialVersionUID = -8091879091924046844L;
	private String jwttoken;
	private long userid;
	private  String username;
	private String email;
	private String completename;
	private Wallet wallet;
	private Date creationDate;
	private long lose;
	private long win;
	
	public JwtResponse(String jwttoken, long userid, String username, String email, String completename, Wallet wallet,
			Date creationDate, long lose, long win) {
		super();
		this.jwttoken = jwttoken;
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.completename = completename;
		this.wallet = wallet;
		this.creationDate = creationDate;
		this.lose = lose;
		this.win = win;
	}


	public String getJwttoken() {
		return jwttoken;
	}


	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCompletename() {
		return completename;
	}


	public void setCompletename(String completename) {
		this.completename = completename;
	}


	public Wallet getWallet() {
		return wallet;
	}


	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public long getLose() {
		return lose;
	}


	public void setLose(long lose) {
		this.lose = lose;
	}


	public long getWin() {
		return win;
	}


	public void setWin(long win) {
		this.win = win;
	}


	public void setUserid(long userid) {
		this.userid = userid;
	}


	public String getToken() {
		return this.jwttoken;
	}

	public long getUserid() {
		return userid;
	}
	
}
