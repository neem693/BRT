package com.theComments.brt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Oauth2GlobalMethodSecurity extends GlobalMethodSecurityConfiguration{
	
	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		// TODO Auto-generated method stub
		return new OAuth2MethodSecurityExpressionHandler();
	}

}
