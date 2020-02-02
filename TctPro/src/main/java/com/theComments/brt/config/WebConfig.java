package com.theComments.brt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.addCorsMappings(registry);
		//registry.addMapping("/**").allowedOrigins("http://127.0.0.1:4200").allowCredentials(true);;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
		////////////////////////////////////////////////
		///////////////////WARING!!!!!!!!!!!!!!!!!!!!!!
		//////WINDOW CONFIG/////////////////////////////
		registry
	      .addResourceHandler("/tctFile/workImage/**")
	      .addResourceLocations("file:///D:/tctFile/workImage/");
		registry
	      .addResourceHandler("/tctFile/evalImage/**")
	      .addResourceLocations("file:///D:/tctFile/evalImage/");
		
	}
	
  @Bean
   public RestTemplate getRestTemplate() {
      return new RestTemplate();
   }

}
