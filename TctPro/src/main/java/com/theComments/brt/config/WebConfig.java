package com.theComments.brt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.addCorsMappings(registry);
		//registry.addMapping("/**").allowedOrigins("http://127.0.0.1:4200").allowCredentials(true);;
	}

}
