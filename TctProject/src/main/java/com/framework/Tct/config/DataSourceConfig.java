package com.framework.Tct.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
	
	@Bean
	@Primary
	@Qualifier("primaryDataSource")
	@ConfigurationProperties("app.datasource")
	public DataSource primaryDataSource(DataSourceProperties properties) {
		return primaryDataSourceProperties().initializeDataSourceBuilder().build();
	}
	
	@Bean
	@Primary 
	@ConfigurationProperties("app.datasource")
	public DataSourceProperties primaryDataSourceProperties() {
		
		return new DataSourceProperties();
		
	}
	

}
