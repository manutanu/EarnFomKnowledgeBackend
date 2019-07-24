/**
* 
* @Description Entity for holding all Leagues related details 
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
@Table(name="league_types")
public class LeagueTypes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long leaguetypeid;
	
	@Column(name="leagueName")
	private String leagueName;
	
	@Column(name="amount")
	private long amount;
	
	@Column(name="description")
	private String description;
	

	
	
	public long getLeaguetypeid() {
		return leaguetypeid;
	}

	public void setLeaguetypeid(long leaguetypeid) {
		this.leaguetypeid = leaguetypeid;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
