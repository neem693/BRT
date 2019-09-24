package com.example.demo.oAuth2;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResoureConfig extends GlobalMethodSecurityConfiguration {
	
	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		// TODO Auto-generated method stub
		return new OAuth2MethodSecurityExpressionHandler();
	}
	
	@Override
	public MethodInterceptor methodSecurityInterceptor() throws Exception {
		// TODO Auto-generated method stub
		return super.methodSecurityInterceptor();
	}
	
	@Primary
	@Bean
	public RemoteTokenServices tokenService() {
		RemoteTokenServices tokenService = new RemoteTokenServices();
		tokenService.setCheckTokenEndpointUrl("http://localhost:8081/oauth/check_token");
		tokenService.setClientId("TctTest");
		tokenService.setClientSecret("12341234aa");
		return tokenService;
		
	}

}
