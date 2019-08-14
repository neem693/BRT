package com.framework.Tct.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.Tct.websocket.socketResource.Greeting;
import com.framework.Tct.websocket.socketResource.HelloMessage;

@Controller
@RequestMapping(value ="/websocket")
public class WebsocketController {
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception{
		Thread.sleep(1000);
		return new Greeting("Hello, " + message.getName() + "!");
	}

}
