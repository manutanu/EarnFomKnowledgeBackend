/**
* 
* @Description Entity for holding all user related details
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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class UserStuff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid ;
	
	@Column(name="username")
	@NotNull
	private String username;
	
	@Column(name="completename")
	@NotNull
	private String completeName;
	
	@Column(name="email")
	@NotNull
	private String email;
	
	@Column(name="password")
	@NotNull
	private String password;
	
	@Column(name="creationDate")
	private Date creationDate;
	
	@Column(name="updationDate")
	private Date updationDate;
	
	@Column(name="activated")
	private int activated;
	
	@Column(name="wins")
	private long wins;
	
	@Column(name="lose")
	private long lose;
	
	@OneToOne
	private Wallet walletid;
	
	@PrePersist
	public void setDateOfCreation() {
		this.creationDate=new Date();
	}
	
	@PreUpdate
	public void setDateOfUpdation() {
		this.updationDate=new Date();
	}
	
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdationDate() {
		return updationDate;
	}

	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}

	public int getActivated() {
		return activated;
	}

	public void setActivated(int activated) {
		this.activated = activated;
	}

	public long getWins() {
		return wins;
	}

	public void setWins(long wins) {
		this.wins = wins;
	}

	public long getLose() {
		return lose;
	}

	public void setLose(long lose) {
		this.lose = lose;
	}

	public Wallet getWalletid() {
		return walletid;
	}

	public void setWalletid(Wallet walletid) {
		this.walletid = walletid;
	}
	
	
}
