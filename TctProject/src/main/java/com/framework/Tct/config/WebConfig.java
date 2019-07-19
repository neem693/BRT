package com.framework.Tct.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.framework.Tct.interceptor.TctInterCeptor;

@Component
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	TctInterCeptor interceptorTct;
	
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(interceptorTct).addPathPatterns("/test/interCeptorTest");
	}

	
	
}
