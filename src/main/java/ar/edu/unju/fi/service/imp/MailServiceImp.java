/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author Enzo Sandoval
 *
 */
@Service
public class MailServiceImp {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(String from, String to, String subject, String body) {

		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setFrom(from);
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(body);

		javaMailSender.send(mail);
	}
}
