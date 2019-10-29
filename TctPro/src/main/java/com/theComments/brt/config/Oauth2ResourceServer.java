package com.theComments.brt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import com.theComments.brt.constFile.AuthUser;

@Configuration
@EnableResourceServer
public class Oauth2ResourceServer extends ResourceServerConfigurerAdapter {
	
	private String [] resouseMatch = {
			"/",
			"/*.js",
			"/*.css",
			"/assets/**",
			"/favicon.ico"
	};
	private String [] restController = {
			"/v1/member_public/**",
			"/test/**"
	};
	
	private String [] publicController = {
			"/member/join",

	};
	
	private String [] common_user_auth = {
			"/v1/type/**",
			"/v1/works/**",
			"/v1/artist/**"
	};
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(http);
		//Role 지워야 함
		String common_user = AuthUser.USER_AUTHORITY.COMMON_USER.split("ROLE_")[1];
		
		http.authorizeRequests()
		.antMatchers(resouseMatch).permitAll()
		.antMatchers(restController).permitAll()
		.antMatchers(publicController).permitAll()
		.antMatchers(common_user_auth).hasRole(common_user);
		
	}

}
