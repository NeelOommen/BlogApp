package com.neeloommen.article_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "com.neeloommen.article_backend")
@EnableWebMvc
@ComponentScan("com.neeloommen.article_backend.repositories")
@ComponentScan("com.neeloommen.article_backend.controllers")
@ComponentScan("com.neeloommen.article_backend.services")
public class ArticleBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleBackendApplication.class, args);
	}

}
