package fr.cg95.cvq.util.mail.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.sun.istack.internal.ByteArrayDataSource;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.util.mail.IMailService;

public final class MailService implements IMailService {

    private static Logger logger = Logger.getLogger(MailService.class);
    
    private String systemEmail;
    private JavaMailSender mailSender;

    @Override
    public void send(final String from, final String to, final String[] cc, final String subject, 
            final String body, final Map<String, byte[]> attachments)
        throws CvqException {

        if (to == null)
            throw new CvqModelException("email.to_is_required");
        
        logger.debug("send() sending mail with " + subject);
        try {
            mailSender.send(new MimeMessagePreparator() {
                public void prepare(MimeMessage mimeMessage)
                    throws MessagingException {
                    MimeMessageHelper message =
                        new MimeMessageHelper(mimeMessage, true, "UTF-8");
                    if (from != null && !from.equals(""))
                        message.setFrom(from);
                    else {
                        if (SecurityContext.getCurrentSite().getAdminEmail() != null && !SecurityContext.getCurrentSite().getAdminEmail().trim().isEmpty()) {
                            message.setFrom(SecurityContext.getCurrentSite().getAdminEmail());
                        } else {
                            message.setFrom(systemEmail);
                        }
                    }
                    if (!to.equals(""))
                        message.setTo(to);
                    else {
                        if (SecurityContext.getCurrentSite().getAdminEmail() != null && !SecurityContext.getCurrentSite().getAdminEmail().trim().isEmpty()) {
                            message.setTo(SecurityContext.getCurrentSite().getAdminEmail());
                        } else {
                            message.setTo(systemEmail);
                        }
                    }
                    message.setSubject(subject);
                    message.setText(body);
                    if (cc != null && cc.length > 0)
                        message.setCc(cc);
                    if (attachments != null) {
                        for (Map.Entry<String, byte[]> attachment : attachments.entrySet()) {
                            if (attachment.getValue() != null) {
                                message.addAttachment(attachment.getKey(),
                                    new ByteArrayResource(attachment.getValue()));
                            }
                        }
                    }
                }
            });
        } catch (MailException ex) {
            logger.error(ex.getMessage());
            throw new CvqException("Unable to send email message");
        }
    }

    @Override
    public void send(final String from, final String to, final String[] cc, final String subject,
        final String body, final byte[] attachment, final String attachmentName)
        throws CvqException {
        Map<String, byte[]> attachments = new HashMap<String, byte[]>(1);
        attachments.put(attachmentName, attachment);
        send(from, to, cc, subject, body, attachments);
    }

    @Override
    public void send(final String from, final String to, final String[] cc, final String subject, 
            final String body) throws CvqException {

        send(from, to, cc, subject, body, null);
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }
  
    @Override
    public void sendBase64Attachment(final String from, final String to, final String[] cc,
            final String subject, final String body, final byte[] attachment,
            final String attachmentName, final String attachmentType) throws CvqException {
        try {
            Session session = ((JavaMailSenderImpl) mailSender).getSession();
            MimeMessage message = new MimeMessage(session);
            message.addRecipients(Message.RecipientType.TO, to);
            message.setFrom(new InternetAddress(from));
            if (cc != null) {
                for (int i = 0; i < cc.length; i++) {
                    message.addRecipients(Message.RecipientType.CC, cc[i]);
                }
            }
            message.setSentDate(new Date());
            message.setSubject(subject);
            message.setText(body);

            DataSource source = new ByteArrayDataSource(attachment, attachmentType);
            MimeBodyPart bodypart = new MimeBodyPart();
            bodypart.setDataHandler(new DataHandler(source));
            bodypart.setFileName(attachmentName);
            bodypart.addHeader("Content-type", attachmentType + "; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(bodypart);
            message.setContent(multipart);
            message.saveChanges();
            bodypart.setHeader("Content-Transfer-Encoding", "base64");

            Transport.send(message);
        } catch (MessagingException e) {
            logger.error(e.getMessage());
            throw new CvqException("Unable to send email message");
        }

    }
}
