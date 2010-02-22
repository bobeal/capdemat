package fr.cg95.cvq.service;

import java.io.File;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.mail.IMailService;

/**
 * The tests for the mail service.
 *
 * @author bor@zenexity.fr
 */
public class MailServiceTest extends ServiceTestCase {

    @Autowired
    protected IMailService mailService;
    
    @Test
    public void testMail() throws CvqException {

        String to = "bor@zenexity.fr";
        String from = "bobeal@zenexity.fr";
        String[] ccs = new String[] { "bobeal@gmail.com" };
        String subject = "Un email de votre administration";
        String body = "Veuillez trouver ci-joint le document que vous avez commandé ...";
        File file = getResourceFile("Referentiel General Interoperabilite Volet Technique V0.90.pdf");

        mailService.send(from, to, ccs, subject, body, file);
    }
}
