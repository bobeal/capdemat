package fr.cg95.cvq.service;

import java.io.File;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.testtool.ServiceTestCase;

/**
 * The tests for the mail service.
 *
 * @author bor@zenexity.fr
 */
public class MailServiceTest extends ServiceTestCase {

    public void testMail() throws CvqException {

        String to = "bor@zenexity.fr";
        String from = "bobeal@zenexity.fr";
        String[] ccs = new String[] { "bobeal@gmail.com" };
        String subject = "Un email de votre administration";
        String body = "Veuillez trouver ci-joint le document que vous avez commandé ...";
        File file = getResourceFile("Referentiel General Interoperabilite Volet Technique V0.90.pdf");

        iMailService.send(from, to, ccs, subject, body, file);
    }
}
