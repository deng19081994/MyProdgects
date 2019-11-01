package com.javarush.task.task40.myEmailTask;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    public static void main(String[] args) throws MessagingException {
        String myEmail = "deng19081994@gmail.com";
        String recipientEmail = "deng1994@mail.ru";
        String password = "61alex1994";

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.sendpartial", "true");

        Session session = Session.getDefaultInstance(props);

        MimeMessage message = new MimeMessage(session);
        message.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(recipientEmail), new InternetAddress(myEmail)});
        message.setSubject("Лови письмо, олень!");
        message.setText("Жопа с ручками, это всё отработало...");

        Transport transport = session.getTransport();
        transport.connect(myEmail, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
