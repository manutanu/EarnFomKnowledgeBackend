package com.KnowledgeQuizApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories("com.KnowledgeQuizApp.repository")
@ComponentScan("com.KnowledgeQuizApp")
@SpringBootApplication
public class KnowledgeQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowledgeQuizApplication.class, args);
		
	}

}
