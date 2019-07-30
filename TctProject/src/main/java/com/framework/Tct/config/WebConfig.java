package com.framework.Tct.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.framework.Tct.interceptor.TctInterCeptor;

@Component
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	TctInterCeptor interceptorTct;
	
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(interceptorTct).addPathPatterns("/test/interCeptorTest");
		registry.addInterceptor(localeChangeIntercepto()).addPathPatterns("/inter/**");
	}
	
	/*밑으로는 다국어 인터셉터*/
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.KOREA);
		return sessionLocaleResolver;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeIntercepto() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		return localeChangeInterceptor;
	}
	
	

	
	
}
