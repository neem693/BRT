package com.theComments.brt.app.common;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.yaml.snakeyaml.Yaml;

public class EmailSender {

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
	 * @param param 해당 html의 해당 키를 리플레이스
 	 * @param toList 보낼 email 주소 리ㅡ트
	 * @return 200 혹은 throw exception
	 * @throws Exception 
	 */
	public static Integer sendEmail(String subject, String body,Map<String,Object> param, List<String> toList) throws Exception {
		
        Set<String> paramSet = param.keySet();
        String key= "";
		
		Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", PORT); 
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.auth", "true");

        // Create a Session object to represent a mail session with the specified properties. 
    	Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information. 
    	
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
        
        for(int i =0; i<toList.size(); i++) {
        	 msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toList.get(i)));
        }
       
        msg.setSubject(subject);
        Iterator<String> set = paramSet.iterator();
        
        while(set.hasNext()) {
        	key = set.next();
        	body = body.replaceAll(Pattern.quote(key), param.get(key).toString());
        }
        msg.setContent(body,"text/html;charset=UTF-8;");
        
        // Add a configuration set header. Comment or delete the 
        // next line if you are not using a configuration set
//        msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
            
        // Create a transport.
        Transport transport = session.getTransport();
                    
        // Send the message.
        try
        {
//            System.out.println("Sending...");
            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
        	
            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
//            System.out.println("Email sent!");
            transport.close();
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
            transport.close();
            throw new Exception(ex.getMessage());
        }
        finally
        {
            // Close and terminate the connection.
            
        }
		
		return 200;
	}

}
