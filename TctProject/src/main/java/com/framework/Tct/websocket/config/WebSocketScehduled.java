package com.framework.Tct.websocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.framework.Tct.websocket.socketResource.Greeting;

//@Component
public class WebSocketScehduled {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	private static int i =0;

	@Scheduled(fixedRate = 2000)
	public void webSocketScedule() {
		i++;
		Greeting ob = new Greeting(String.valueOf(i));
		template.convertAndSend("/topic/greetings", ob);
		
	}
	
}
