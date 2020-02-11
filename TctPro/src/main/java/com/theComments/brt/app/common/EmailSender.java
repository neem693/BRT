package com.theComments.brt.app.common;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import com.theComments.brt.jpa.theComment.model.SendEmail;

public class EmailSender {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailSender.class);

	// Replace smtp_username with your Amazon SES SMTP user name.
	static String SMTP_USERNAME = "";

	// Replace smtp_password with your Amazon SES SMTP password.
	static String SMTP_PASSWORD = "";
	
	// Replace sender@example.com with your "From" address.
    // This address must be verified.
    static String FROM = "";
    static String FROMNAME = "";
    
    // Amazon SES SMTP host name. This example uses the 미국 서부(오레곤) region.
    // See https://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
    // for more information.
    // 우린 시드니
    static String HOST = "";
    
    static String PORT = "";
	
	static {
		Yaml yaml = new Yaml();
		InputStream inputStream = EmailSender.class.getClassLoader().getResourceAsStream("application.yml");
		Map<String, Object> property = yaml.load(inputStream);
		Map<String,Object> smtp = (Map<String, Object>)property.get("AWS_SMTP");
		
		SMTP_USERNAME = smtp.get("SMTP_USERNAME").toString();
		SMTP_PASSWORD = smtp.get("SMTP_PASSWORD").toString();
		FROM = smtp.get("FROM").toString();
		FROMNAME = smtp.get("FROMNAME").toString();
		HOST = smtp.get("HOST").toString();
		PORT = smtp.get("PORT").toString();
	}
	
	
	
	
	/**
	 * 
	 * @param subject 해당 메일의 제목
	 * @param body 해당 메일의 html 부분
 	 * @param toList 보낼 email 주소 리ㅡ트
	 * @return 200 혹은 throw exception
	 * @throws Exception 
	 */
	public static Integer sendEmail(List<SendEmail> emailList) throws Exception {
		
//        Set<String> paramSet = param.keySet();
        String key= "";
		
		Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", PORT); 
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.auth", "true");

    	Session session = Session.getDefaultInstance(props);

        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
     
        Transport transport = session.getTransport();
        transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
        	
            // Send the email.
           
            for(SendEmail mail: emailList) {
                msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.getEmail()));
                msg.setSubject(mail.getEmail_template().getTemplate_subject());
                msg.setContent(mail.getSend_text(),"text/html;charset=UTF-8;");
                try {
					transport.sendMessage(msg, msg.getAllRecipients());
					mail.setStatus(2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error("MAIL SEND ERROR : " + mail.getEmail());
				}
               
            }
//            System.out.println("Email sent!");
            transport.close();
		
		return 200;
	}

}
