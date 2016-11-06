package com.rainhowchan.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.junit.Test;

public class MailUtils {
	@Test
	public static void sendMail(String to,String code) throws Exception{
		Properties props=new Properties();
		props.setProperty("mail.host", "localhost");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(props,new Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com", "111");
			}
		});
		session.setDebug(true);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("service@shop.com"));
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		message.setSubject("来自RainhowChan的激活邮件");
		message.setContent("<h1>来自RainhowChan的官网激活邮件</h1><p>点击下面链接进行激活</p><h3><a href='http://192.168.2.88:8080/Shop/user_active.action?code="+code+"'>http://192.168.2.88:8080/Shop/user_active.action?code="+code+"</a></h3>","text/html;charset=utf-8");
		
		Transport.send(message);
	}
}
