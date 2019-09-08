package com.framework.Tct;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test1")
@Configuration
public class MockitoTestConfiguration {
	
	@Bean
	@Primary
	public MockitoService mokitoService() {
		return Mockito.mock(MockitoService.class);
	}
	

}
