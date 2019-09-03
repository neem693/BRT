package com.framework.Tct.sendSms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.framework.Tct.Const.PrivateConst;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



@RestController
public class SendSms {
	
	@RequestMapping("/SendMessage")
	public String sendMessage() {
		
		Message.creator(new PhoneNumber(PrivateConst.TWILO.TO_SEND), new PhoneNumber(PrivateConst.TWILO.TO_FROM), "Message ORATREE 테스트").create();
		
		return "성공";
	}

}
