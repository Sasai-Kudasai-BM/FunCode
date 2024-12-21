package net.skds.funcode;

import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;

import java.util.Properties;

public class ESMTP {

	public static void main(String[] args) throws Exception {

		Properties properties = new Properties();

		properties.put("mail.transport.protocol", "smtps");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.user", "artem.boiar");
		properties.put("mail.smtp.ssl.enable", true);
		properties.put("mail.smtp.auth", false);
		properties.put("mail.debug", true);
		//new InternetAddress("smtp.gmail.com")
		Session session = Session.getInstance(properties);
		Transport transport = session.getTransport(new InternetAddress("smtp.gmail.com"));
		transport.connect();
	}

}
