package com.theComments.brt.config;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.yaml.snakeyaml.Yaml;

import com.theComments.brt.constFile.AuthUser;

@Configuration
@EnableResourceServer
public class Oauth2ResourceConfig extends ResourceServerConfigurerAdapter {
	
	private String [] resouseMatch = {
			"/",
			"/*.js",
			"/*.css",
			"/assets/**",
			"/favicon.ico"
	};
	private String [] restController = {
			"/v1/member_public/**",
			"/test/**",
			"/v1/type/**",
			"/v1/worksPublic/**",
			"/v1/artistPublic/**",
			"/v1/evalPublic/**"
			
	};
	
	private String [] publicController = {
			"/member/*",
			"/eval/share/*",
			"/oauth2/authorization/*"


	};
	
	private String [] common_user_auth = {
			
			"/v1/works/**",
			"/v1/artist/**",
			"/v1/eval/**"
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
//		.and()
//		.oauth2Login()
//		.defaultSuccessUrl("/member/snsLoginSuccess",true)
//		.failureUrl("/member/snsLoginFailure")
//		.clientRegistrationRepository(clientRegistrationRepository())
//		.authorizedClientService(authorizedClientService());
		
	}

//////////////////////////////SNS LOGIN//////////////////////

//	private static List<String> clients = Arrays.asList("google");
//	private static String CLIENT_PROPERTY_KEY = "spring.security.oauth2.client.registration.";
//
//	@Bean
//	public ClientRegistrationRepository clientRegistrationRepository() {
//		List<ClientRegistration> registraions = clients.stream().map(c -> getRegistration(c))
//				.filter(registration -> registration != null).collect(Collectors.toList());
//
//		return new InMemoryClientRegistrationRepository(registraions);
//
//	}
//
//	private ClientRegistration getRegistration(String client) {
////yml을 가져옴
//		Yaml yaml = new Yaml();
//		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("application.yml");
//		Map<String, Object> property = yaml.load(inputStream);
//
//		property = (Map<String, Object>) property.get(client);
//		String clientId = (String) property.get("client-id");
//		String clientSecret = (String) property.get("client-secret");
//		if (clientId == null) {
//			return null;
//		}
//
////String clientSecret = env.getProperty(CLIENT_PROPERTY_KEY + client + ".client-secret");
//
//		if (client.equals("google")) {
//			return CommonOAuth2Provider.GOOGLE.getBuilder(client).clientId(clientId).clientSecret(clientSecret).build();
//		}
//		if (client.equals("facebook")) {
//			return CommonOAuth2Provider.FACEBOOK.getBuilder(client).clientId(clientId).clientSecret(clientSecret)
//					.build();
//		}
//		return null;
//
//	}
//
//	@Bean
//	public OAuth2AuthorizedClientService authorizedClientService() {
//		return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
//	}

}
