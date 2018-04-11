package mail;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {
	public static String myEmailAccount = "hgguirong@qq.com";//发件人
    public static String myEmailPassword = "mpkdkswmsvlsjehc";//密码要用授权码
    public static String myEmailSMTPHost = "smtp.qq.com";//qq邮箱服务器
    public static String receiveMailAccount = "hgguirong@qq.com";//收件人

    public static void main(String[] args) throws Exception {
    	Properties properties = new Properties();
    	properties.setProperty("mail.host", "smtp.qq.com");
    	properties.setProperty("mail.transport.protocol", "smtp");
    	properties.setProperty("mail.smtp.auth", "true");
    	properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    	properties.setProperty("mail.smtp.port", "465");
    	properties.setProperty("mail.smtp.socketFactory.port", "465");
         
         // 2. 根据配置创建会话对象, 用于和邮件服务器交互
         Session session = Session.getInstance(properties);
         session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log

         // 3. 创建一封邮件
         MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount);
         Transport transport = session.getTransport();
         transport.connect(myEmailAccount,myEmailPassword);
         transport.sendMessage(message, message.getAllRecipients());
         transport.close();

    }
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(sendMail, "测试", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));

        // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        message.setSubject("测试邮件", "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        message.setContent("测试内容:XX用户你好, 今天全场5折, 快来抢购, 错过今天再等一年。。。", "text/html;charset=UTF-8");
        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }
}
