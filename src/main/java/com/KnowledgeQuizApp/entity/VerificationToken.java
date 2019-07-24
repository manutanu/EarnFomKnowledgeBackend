/**
* 
* @Description Entity for holding all verification Tokens needed during registration 
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="verification_token")
public class VerificationToken {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tokenid;
	
	@Column(name="token")
	private String token;
	
	@Column(name="expiryDate")
	private Date expiryDate;
	
	@OneToOne
	private UserStuff userid;
	

	public long getTokenid() {
		return tokenid;
	}

	public void setTokenid(long tokenid) {
		this.tokenid = tokenid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public UserStuff getUserid() {
		return userid;
	}

	public void setUserid(UserStuff userid) {
		this.userid = userid;
	}
	
	
}
