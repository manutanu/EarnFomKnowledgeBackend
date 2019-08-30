/**
* 
* @Description Entity for User Wallet to show amount in their wallet
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
@Table(name="wallet")
public class Wallet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long walletid;
	
	@Column(name="walletmoney")
	private long walletmoney;

	
	public long getWalletid() {
		return walletid;
	}

	public void setWalletid(long walletid) {
		this.walletid = walletid;
	}

	public long getWalletmoney() {
		return walletmoney;
	}

	public void setWalletmoney(long walletmoney) {
		this.walletmoney = walletmoney;
	}
	
}
