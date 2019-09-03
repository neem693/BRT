package com.framework.Tct.sendSms.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.PrivilegedActionException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.framework.Tct.Const.PrivateConst;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



@RestController
public class SendSms {
	
	@RequestMapping("/SendMessage")
	public String sendMessage() {
		
		Message.creator(new PhoneNumber(PrivateConst.TWILO.TO_SEND), new PhoneNumber(PrivateConst.TWILO.TO_FROM), "Message ORATREE 테스트").create();
		
		return "성공";
	}
	
	@RequestMapping("/SendVoice")
	public String sendVoice() throws URISyntaxException {
		
		Call.creator(new PhoneNumber(PrivateConst.TWILO.TO_SEND),new PhoneNumber(PrivateConst.TWILO.TO_FROM), new URI("http://demo.twilio.com/docs/voice.xml")).create();
		
		return "성공";
	}

}
