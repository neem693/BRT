package com.framework.Tct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.framework.Tct.Const.PrivateConst;
import com.twilio.Twilio;

@SpringBootApplication
@EnableScheduling
@EnableEurekaClient
@RefreshScope
@EnableHystrix
public class TctProjectApplication extends SpringBootServletInitializer implements ApplicationRunner {
	
	static {
		
		Twilio.init(
				PrivateConst.TWILO.ACCOUNTSID, 
				PrivateConst.TWILO.TOKKEN);
	}
	
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(TctProjectApplication.class);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	


	public static void main(String[] args) {
		SpringApplication.run(TctProjectApplication.class, args);
	}


	
	public void sendMessage(String msg) {
		kafkaTemplate.send("TCTREGISTER",msg);
	}
	
	@KafkaListener(topics = "TCTREGISTER",groupId = "foo")
	public void listen(String message) {
		System.out.println("Received Message in group - group-id: " + message);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		sendMessage("Hi Welcome to Spring for Apache kafka");
	}

}
