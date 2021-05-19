package ru.itis.architecture.configs;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SenderConfig {
    private Properties props;
    private static SenderConfig instance;

    // настройки gmail
    public SenderConfig() {
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }

    // pattern Singleton
    public static synchronized SenderConfig getInstance() {
        if (instance == null) {
            instance = new SenderConfig();
        }
        return instance;
    }

    public void send(String subject, String text, String toEmail){
        String email = "ainurgatin@gmail.com";
        String password = "ainur08_A";

        // Ауентификация и создание сессии
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

        // настройка отправляемого сообщения
        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);
            message.setContent(text, "text/html");

            // отправка сообщения
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
