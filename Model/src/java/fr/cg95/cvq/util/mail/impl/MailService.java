package fr.cg95.cvq.util.mail.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.util.mail.IMailService;

public final class MailService implements IMailService {

    private static Logger logger = Logger.getLogger(MailService.class);
    
    private String systemEmail;
    private JavaMailSender mailSender;

    public void send(final String from, final String to, final String[] cc, final String subject, 
            final String body, final byte[] attachment, final String attachmentName) 
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
                    if (attachment != null) {
                      ByteArrayResource byteArrayResource = new ByteArrayResource(attachment);
                      message.addAttachment(attachmentName, byteArrayResource);
                    }
                }
            });
        } catch (MailException ex) {
            logger.error(ex.getMessage());
            throw new CvqException("Unable to send email message");
        }
    }

    public void send(final String from, final String to, final String[] cc, final String subject, 
            final String body) throws CvqException {

        send(from, to, cc, subject, body, null, null);
    }

    public void send(final String from, final String to, final String[] cc,
                     final String subject, final String body,
                     final File attachment)
        throws CvqException {

        if (!attachment.exists())
            throw new CvqException("attachement " + attachment.getName() + " not found");
        byte[] attachmentData = new byte[(int) attachment.length()];
        try {
            FileInputStream fis = new FileInputStream(attachment);
            fis.read(attachmentData);
        } catch (FileNotFoundException e) {
            // unlikely to happen since we already checked that
        } catch (IOException ioe) {
            throw new CvqException("error reading data from file " + attachment.getName());
        }

        send(from, to, cc, subject, body, attachmentData, attachment.getName());
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }
}
