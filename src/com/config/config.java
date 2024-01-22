package com.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;


import jakarta.persistence.EntityManagerFactory;
@Configuration
@EnableWebMvc
@ComponentScan("com.jpa")
@EnableJpaRepositories("com.jpa.dao")
@EnableTransactionManagement
public class config implements WebMvcConfigurer{
	

	@Bean
	  public InternalResourceViewResolver getViewResolver() {
		  InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		  
		  viewResolver.setPrefix("/WEB-INF/jsp/");
		  viewResolver.setSuffix(".jsp");
		  
		  return viewResolver;
	  }
	 @Bean
	    public StandardServletMultipartResolver multipartResolver() {
	        return new StandardServletMultipartResolver();
	    }
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource  	 dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springdb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
	
	 @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
	        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	        entityManagerFactoryBean.setDataSource(dataSource);
	        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	        entityManagerFactoryBean.setPackagesToScan("com.jpa"); // Replace with your entity package
	        
	        Properties jpaProperties = new Properties();
	        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        jpaProperties.put("hibernate.show_sql", "true");
	        entityManagerFactoryBean.setJpaProperties(jpaProperties);
	        
	        return entityManagerFactoryBean;
	    }
	 
	 @Bean
	    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(emf);
	        return transactionManager;
	    }
}
