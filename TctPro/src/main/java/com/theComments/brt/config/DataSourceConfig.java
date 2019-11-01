package com.theComments.brt.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource(value ="classpath:dataSourceConfig.yml", factory=YamlPropertyLoaderFactory.class)
public class DataSourceConfig {
	
	@Bean
	@Primary
	@Qualifier("primaryDataSource")
	public HikariDataSource primaryDataSource() {
		HikariConfig hsc = new HikariConfig();
		hsc.setUsername(primaryDataSourceProperties().getUsername());
		hsc.setPassword(primaryDataSourceProperties().getPassword());
		hsc.setDriverClassName(primaryDataSourceProperties().getDriverClassName());
		hsc.setJdbcUrl(primaryDataSourceProperties().getUrl());
		
		hsc.setMaximumPoolSize(20);
		
		HikariDataSource hs = new HikariDataSource(hsc);
		
		return hs;
	}
	
	@Bean
	@Primary 
	@ConfigurationProperties("app.datasource")
	public DataSourceProperties primaryDataSourceProperties() {
		
		return new DataSourceProperties();
		
	}

}
