package com.framework.Tct.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.MariaDB53Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		basePackages = "com.framework.Tct.jpa.Jpa1.dao",
		entityManagerFactoryRef = "userEntityManager",
		transactionManagerRef = "userTransactionManager"
		)
public class JpaConfig {
	
	
	@Autowired
	@Qualifier("primaryDataSource")
	DataSource primaryDatasource;
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean userEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(primaryDatasource);
		em.setPackagesToScan(new String[] {"com.framework.Tct.jpa.Jpa1.model"});
		
		HibernateJpaVendorAdapter vendorAdapter =  new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		Map<String,Object> properties = new HashMap<String,Object>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MariaDB53Dialect");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		
		em.setJpaPropertyMap(properties);
		
		return em;
		
	}
	
	@Primary
	@Bean
	public PlatformTransactionManager userTransactionManager() {
		
		JpaTransactionManager transac = new JpaTransactionManager();
		transac.setEntityManagerFactory(userEntityManager().getObject());
		return transac;
		
	}
	
	@Bean
	@Qualifier("emFac1")
	public EntityManagerFactory getEntityManager() {
		return userEntityManager().getObject();
	}

}
