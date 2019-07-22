/**
* 
* @Description Repository to interact with database and fetch Wallet details of user
* @author Mritunjay Yadav
* @Type Repository
*
*/
package com.KnowledgeQuizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KnowledgeQuizApp.entity.Wallet;

@Repository
public interface WalletRespository extends JpaRepository<Wallet, Long> {

}
