package com.example.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.dialect.MariaDB103Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@EnableTransactionManagement
public class HibernateConfig {
	
	@Autowired
	@Qualifier("primaryDataSource")
	DataSource primaryDataSource;
	
//	@Bean
//	public LocalSessionFactoryBean sessionFactory() {
//		
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(primaryDataSource);
//		sessionFactory.setPackagesToScan(new String[] {"com.example.demo.config"});
//		sessionFactory.setHibernateProperties(hibernateProperties());
//		return sessionFactory;
//		
//	}
	
//	@Bean
//	public PlatformTransactionManager hibernateTransactionManager() {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//		transactionManager.setSessionFactory(sessionFactory().getObject());
//		return transactionManager;
//	}
	
//	private final Properties hibernateProperties() {
//		Properties hibernateProperties = new Properties();
//		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "crate-drop");
//		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDB103Dialect");
//		return hibernateProperties;
//	}
	
	

}
