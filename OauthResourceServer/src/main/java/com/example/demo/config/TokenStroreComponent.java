//package com.example.demo.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//
//@Configuration
//public class TokenStroreComponent {
//	
//	@Autowired
//	@Qualifier("primaryDataSource")
//	DataSource primaryDataSource;
//	
//	@Bean
//	public TokenStore toeknStroeBean() {
//		return new JdbcTokenStore(primaryDataSource);
//	}
//
//}
