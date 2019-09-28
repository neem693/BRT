package com.example.demo.oAuth2;

import java.io.IOException;

import org.aopalliance.intercept.MethodInterceptor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.example.demo.config.CheckTokenConverter;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResoureConfig extends GlobalMethodSecurityConfiguration {
	
	@Autowired
	CheckTokenConverter converter;
	
	private String publicKey;
	
	
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
	
	@Bean
	public JwtAccessTokenConverter tokenConvter() {
		
		Resource publicKeyRes = new ClassPathResource("key/publicKey.txt");
		
		try {
			this.publicKey = new String(IOUtils.toByteArray(publicKeyRes.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setVerifierKey(publicKey);
		jwtAccessTokenConverter.setAccessTokenConverter(converter);
		return jwtAccessTokenConverter;
	}
	
	
	@Bean
	public TokenStore jwtTokenStore() {
		return new JwtTokenStore(tokenConvter());
	}
	
	@Primary
	@Bean
	public DefaultTokenServices tokenService() {
		DefaultTokenServices tokenService = new DefaultTokenServices();
		tokenService.setTokenStore(jwtTokenStore());
		return tokenService;
	}
	
//	@Primary
//	@Bean
//	public RemoteTokenServices tokenService() {
//		
//		RemoteTokenServices tokenService = new RemoteTokenServices();
//		tokenService.setCheckTokenEndpointUrl("http://localhost:8081/oauth/check_token");
//		tokenService.setClientId("TctTest");
//		tokenService.setClientSecret("12341234aa");
//		tokenService.setAccessTokenConverter(converter);
//		return tokenService;
//		
//	}

}
