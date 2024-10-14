package mypack;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail
{ 
    public static void send(String to, String sub, 
                         String msg, final String user,final String pass)
    { 
        //create an instance of Properties Class   
        Properties props = new Properties();
     
        //specifies ip address of default mail server
        props.put("mail.smtp.host", "smtp.gmail.com");
        // below mentioned mail.smtp.port is optional 
        props.put("mail.smtp.port", "465");		
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
   
        //pass properties and authenticates session instance
        Session session = Session.getInstance(props,new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
  	 	         return new PasswordAuthentication(user,pass); 
            }
        });

        try {
 
        	//create mime message instance for headers
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);

            //transport message to recipients
            Transport.send(message);
        }
        catch(Exception e) {
    	     e.printStackTrace();
        }
    }  
}
