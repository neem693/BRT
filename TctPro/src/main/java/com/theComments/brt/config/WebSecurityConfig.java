package com.theComments.brt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private String [] resouseMatch = {
			"/",
			"/*.js",
			"/*.css",
			"/assets/**",
			"/favicon.ico"
	};
	private String [] restController = {
			"/v1/member_public/**",
	};
	
	private String [] publicController = {
			"/member/join"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		
		http
		.cors()
		.and()
		.authorizeRequests().antMatchers(resouseMatch).permitAll()
		.antMatchers(restController).permitAll()
		.antMatchers(publicController).permitAll()
		.anyRequest().authenticated()
		.and()
		.csrf()
		.csrfTokenRepository(getCsrfTokenRepository());
//		
		
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Bean
	public CookieCsrfTokenRepository getCsrfTokenRepository() {
		CookieCsrfTokenRepository csrf = CookieCsrfTokenRepository.withHttpOnlyFalse();
		return csrf;
	}
	
}
