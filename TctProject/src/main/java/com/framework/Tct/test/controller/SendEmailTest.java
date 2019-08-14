package com.framework.Tct.test.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class SendEmailTest {
	
	@RequestMapping(value = "/sendemail")
	public String sendEmail() {
		try {
			sendMail();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Email send Successfully";
	}

	private void sendMail() throws AddressException, MessagingException, IOException {
		// TODO Auto-generated method stub
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				//해당하는 인증은 따로 구글 api를 사용한다던가
				//https://myaccount.google.com/lesssecureapps?pli=1
				//에서 lessscrue를 적용시켜야만 한다.

				return new PasswordAuthentication("neem5693@gmail.com","ch01134888");
			}
		});
		
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("neem5693@brt.com",false));
		
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("neem5693@gmail.com"));
		msg.setSubject("BRTBRT email");
		msg.setContent("BRTBRT BRT email","text/html");
		msg.setSentDate(new Date());
		
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("BRT3 email","text/html");
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		MimeBodyPart attachPart = new MimeBodyPart();
		
		attachPart.attachFile("./img/test.jpg");
		multipart.addBodyPart(attachPart);
		msg.setContent(multipart);
		Transport.send(msg);
		
		
		
	}

}
