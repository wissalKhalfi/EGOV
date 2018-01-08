/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.egov.technique;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import esprit.egov.gui.AddPermis;
/**
 *
 * @author Aya
 */
public class SendMail {
    public SendMail(String recipient,String sub,String msg)throws AddressException{
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.user", "aya.benltaifa@esprit.tn");
        properties.put("mail.smtp.password", "ayabenltaifa");
        
        Session session = Session.getDefaultInstance(properties, null);
        Message message = new MimeMessage(session);
        try {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setFrom(new InternetAddress("aya.benltaifa@esprit.tn"));
            message.setSubject(sub);
            message.setText(msg);
            
            
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", "aya.benltaifa@esprit.tn", "ayabenltaifa");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        } catch (MessagingException ex) {
            Logger.getLogger(AddPermis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
