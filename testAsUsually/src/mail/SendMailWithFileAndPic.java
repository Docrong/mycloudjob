package mail;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class SendMailWithFileAndPic {
	public static String myEmailAccount = "hgguirong@qq.com";//发件人
    public static String myEmailPassword = "mpkdkswmsvlsjehc";//密码要用授权码
    public static String myEmailSMTPHost = "smtp.qq.com";//qq邮箱服务器
    public static String receiveMailAccount = "hgguirong@qq.com";//收件人
    
    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("**--请输入密码--**");
    	String ss=sc.nextLine();
    	System.out.println("sc-->"+ss);
    	Properties properties = new Properties();
    	properties.setProperty("mail.host", myEmailSMTPHost);
    	properties.setProperty("mail.transport.protocol", "smtp");
    	properties.setProperty("mail.smtp.auth", "true");
    	properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    	properties.setProperty("mail.smtp.port", "465");
    	properties.setProperty("mail.smtp.socketFactory.port", "465");

    	Session session = Session.getInstance(properties);
        session.setDebug(true); 
        
        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount);
        Transport transport = session.getTransport();
        transport.connect(myEmailAccount,myEmailPassword);
//        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }

    
	private static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message=new MimeMessage(session);
		message.setFrom(new InternetAddress(sendMail,"我的发件人昵称","UTF-8"));
		message.addRecipient(RecipientType.TO, new InternetAddress(receiveMail, "我的收件人昵称", "UTF-8"));
		message.setSubject("测试主题");
		
		//创建图片节点
		MimeBodyPart image=new MimeBodyPart();
		DataHandler dh=new DataHandler(new FileDataSource("C://Users/gr/Pictures/lovewallpaper/4656-106.jpg"));
		
		image.setDataHandler(dh);
		image.setContentID("wallKeeper");
		
		MimeBodyPart text=new MimeBodyPart();
		text.setContent("这是一张壁纸</br><img src='cid:wallKeeper'/>", "text/html;charset=UTF-8");
		
		MimeMultipart mm_text_image = new MimeMultipart();
        mm_text_image.addBodyPart(text);
        mm_text_image.addBodyPart(image);
        mm_text_image.setSubType("related");    // 关联关系
        
        MimeBodyPart text_image = new MimeBodyPart();
        text_image.setContent(mm_text_image);

        // 9. 创建附件“节点”
        MimeBodyPart attachment = new MimeBodyPart();
        DataHandler dh2 = new DataHandler(new FileDataSource("C://Users/gr/Pictures/lovewallpaper/279528-0.zip"));  // 读取本地文件
        attachment.setDataHandler(dh2);                                             // 将附件数据添加到“节点”
        attachment.setFileName(MimeUtility.encodeText(dh2.getName()));              // 设置附件的文件名（需要编码）

        // 10. 设置（文本+图片）和 附件 的关系（合成一个大的混合“节点” / Multipart ）
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text_image);
        mm.addBodyPart(attachment);     // 如果有多个附件，可以创建多个多次添加
        mm.setSubType("mixed");         // 混合关系

        // 11. 设置整个邮件的关系（将最终的混合“节点”作为邮件的内容添加到邮件对象）
        message.setContent(mm);

        // 12. 设置发件时间
        message.setSentDate(new Date());

        // 13. 保存上面的所有设置
        message.saveChanges();

        return message;
	}
}
