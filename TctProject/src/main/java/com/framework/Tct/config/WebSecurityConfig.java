package com.framework.Tct.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.server.session.HeaderWebSessionIdResolver;
import org.springframework.web.server.session.WebSessionIdResolver;

import com.framework.Tct.Const.PublicConst;
import com.framework.Tct.oAuth2.CustomAuthFilter;
import com.framework.Tct.oAuth2.CustomDetailService;
import com.framework.Tct.oAuth2.CustomProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
//	CustomDetailService customDetailService;
	CustomProvider customProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(http);

		 HttpSessionCsrfTokenRepository sessionCsrf = new HttpSessionCsrfTokenRepository();
		 sessionCsrf.setSessionAttributeName(PublicConst.SPRING_SCURITY.CSRF_TOKEN);
		 
		CustomAuthFilter filter = new CustomAuthFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setAuthenticationFailureHandler(failureHandler());

		 /* 시큐리티 기본 베이직 
		http.cors().and()
				//.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
				//.csrf().disable()
				.csrf().csrfTokenRepository(getCookieCsfrTokenRepository()).and()
				//.csrf().csrfTokenRepository(sessionCsrf).and()
				.authorizeRequests().antMatchers("/", "/*.js", "/*.css", "/assets/**", "/Home/**", "/getCsrfToken","/login")
				.permitAll()
				.anyRequest().authenticated().and()
//				.formLogin()
//				.successHandler(successHandler())
//				.failureHandler(failureHandler())
//			    .loginPage("/login").permitAll().and()
				.logout().permitAll();*/
		
		 
		 //oAUth2 전용
		http.cors().and()
		.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
		//.csrf().disable()
		.csrf().csrfTokenRepository(getCookieCsfrTokenRepository()).and()
		.authorizeRequests().antMatchers("/", "/*.js", "/*.css", "/assets/**", "/Home/**", "/getCsrfToken","/login","/oauth/authorize","/h2-console/*")
		.permitAll()
		.anyRequest().authenticated().and()
		.formLogin().permitAll().and()
		//.oauth2Login().permitAll().and()
		.logout().permitAll();
		
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
/*	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring();
	}*/

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(auth);
		//auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");
		auth.authenticationProvider(customProvider);
	}

	private AuthenticationSuccessHandler successHandler() {
		return new AuthenticationSuccessHandler() {
			@Override
			public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse, Authentication authentication)
					throws IOException, ServletException {
				System.out.println("성공");
				httpServletResponse.getWriter().append("OK");
				httpServletResponse.setStatus(200);
			}
		};
	}

	private AuthenticationFailureHandler failureHandler() {
		return new AuthenticationFailureHandler() {
			@Override
			public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse, AuthenticationException e)
					throws IOException, ServletException {
				System.out.println("실패");
				httpServletResponse.getWriter().append("Authentication failure");
				httpServletResponse.setStatus(401);
			}
		};
	}
	
	@Bean
	public CookieCsrfTokenRepository getCookieCsfrTokenRepository(){
		// TODO Auto-generated method stub
		CookieCsrfTokenRepository cookieTokenConfig = CookieCsrfTokenRepository.withHttpOnlyFalse();
		//cookieTokenConfig.setCookiePath("/");
		return cookieTokenConfig;
	}
	
	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
}
