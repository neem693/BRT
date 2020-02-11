package com.theComments.brt.Scheduled;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.theComments.brt.app.common.EmailSender;
import com.theComments.brt.jpa.theComment.dao.SendEmailDao;
import com.theComments.brt.jpa.theComment.model.SendEmail;

@Component
public class Scheduled_component {
	
	@Autowired
	SendEmailDao sendEmailDao;
	
	@Scheduled(fixedRate  = 10000)
	public void sendEmail() {
		
		List<SendEmail> sendList =  sendEmailDao.findNotSendEmail();
		if(sendList.size() == 0) {
			return;
		}
		for(SendEmail mail: sendList) {
			mail.setStatus(1);
		}
		sendEmailDao.saveAll(sendList);
		
		try {
			EmailSender.sendEmail(sendList);
			sendEmailDao.saveAll(sendList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
