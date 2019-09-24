package com.example.demo.config;

import javax.sql.DataSource;

import org.mariadb.jdbc.Driver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:application.yml")
public class DataSourceConfig {
	
	@Bean
	@Primary
	@Qualifier("primaryDataSource")
	public DataSource primaryDataSource(DataSourceProperties properties) {
		return primaryDataSourceProperties().initializeDataSourceBuilder().build();
	}
	
	@Bean
	@Primary 
	@ConfigurationProperties(prefix="app.datasource")
	public DataSourceProperties primaryDataSourceProperties() {
		return new DataSourceProperties();
		
	}
	

}
