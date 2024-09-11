package com.neeloommen.article_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "com.neeloommen.article_backend")
@EnableWebMvc
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@ConfigurationPropertiesScan("com.neeloommen.article_backend.config")
@ComponentScan("com.neeloommen.article_backend.repositories")
@ComponentScan("com.neeloommen.article_backend.controllers")
@ComponentScan("com.neeloommen.article_backend.services")
public class ArticleBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleBackendApplication.class, args);
	}

}
