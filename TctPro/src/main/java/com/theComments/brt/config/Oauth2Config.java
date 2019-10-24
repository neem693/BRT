package com.theComments.brt.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.theComments.brt.auth.CustomTokenEnhancer;

@Configuration
@EnableAuthorizationServer
public class Oauth2Config extends AuthorizationServerConfigurerAdapter {

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	@Qualifier("primaryDataSource")
	DataSource primaryDataSource;

	private String clientId = "b1d3F34G6Th7jd";
	private String clientScrect = "8fdfFdUJed977O0O3JH";
	private String privateKey = "", publicKey = "";

	private int tokenValidSec = 20000;
	private int refreshTokenValidSec = 20000;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Bean
	public JwtAccessTokenConverter tokenEnhancerJwt() {

		Resource privateKeyRes = new ClassPathResource("key/privateKey.txt");
		Resource publicKeyRes = new ClassPathResource("key/publicKey.txt");

		try {
			this.privateKey = new String(IOUtils.toByteArray(privateKeyRes.getInputStream()));
			this.publicKey = new String(IOUtils.toByteArray(publicKeyRes.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(privateKey);
		converter.setVerifierKey(publicKey);
		return converter;

	}
	@Bean
	public TokenEnhancer getCustomTokenEnhancer() {
		return new CustomTokenEnhancer();
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(security);
		security
		.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(clients);
		
		clients
		.jdbc(primaryDataSource)
		.withClient(clientId)
		.secret(encoder.encode(clientScrect))
		.authorizedGrantTypes(
				"password","authorization_code","refresh_token"
				)
		.scopes("read","write");
		
	}
	
	@Bean
	public TokenStore jdbcTokenStore() {
		return new JdbcTokenStore(primaryDataSource);
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(endpoints);
		
		TokenEnhancerChain chain = new TokenEnhancerChain();
		List<TokenEnhancer> tokenList = new ArrayList<TokenEnhancer>();
		
		tokenList.add(getCustomTokenEnhancer());
		tokenList.add(tokenEnhancerJwt());
		
		chain.setTokenEnhancers(tokenList);
		
		endpoints
		.authenticationManager(authenticationManager)
		.tokenStore(jdbcTokenStore())
		.tokenEnhancer(chain);
	}

}
