package mail;

import java.util.Calendar;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SendMail {
    @SuppressWarnings("static-access")
    public static void sendMessage(String smtpHost, String from,
            String fromUserPassword, String to, String subject,
            String messageText, String messageType) throws MessagingException {
        // 第一步：配置javax.mail.Session对象
        System.out.println("为" + smtpHost + "配置mail session对象");

        Properties props = new Properties();
        props.setProperty("mail.host", "smtp.qq.com");
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.debug", "true");
        Session mailSession = Session.getInstance(props, new MyAuthenticator(
                from, fromUserPassword));

        // 第二步：编写消息
        System.out.println("编写消息from——to:" + from + "——" + to);

        InternetAddress fromAddress = new InternetAddress(from);
        InternetAddress toAddress = new InternetAddress(to);
        MimeMessage message = new MimeMessage(mailSession);
        System.out.println(3123);

        message.setFrom(fromAddress);
        message.addRecipient(RecipientType.TO, toAddress);

        message.setSentDate(Calendar.getInstance().getTime());
        message.setSubject(subject);
        message.setContent(messageText, messageType);

        // 第三步：发送消息
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(smtpHost, from, fromUserPassword);
      transport.send(message, message.getRecipients(RecipientType.TO));
        System.out.println("message yes");
    }

    public static void main(String[] args) {
        try {
            SendMail.sendMessage("smtp.qq.com", "hgguirong@qq.com",
                    "mpkdkswmsvlsjehc", "hgguirong@qq.com", "测试邮件主题",
                    "测试邮件内容",
                    "text/html;charset=UTF-8");
            System.out.println(123);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class MyAuthenticator extends Authenticator {
    String userName = "";
    String password = "";

    public MyAuthenticator() {

    }

    public MyAuthenticator(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}