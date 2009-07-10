package fr.cg95.cvq.util.sms;

import fr.cg95.cvq.exception.CvqException;

/**
 * A service that provides SMS sending facilities.
 *
 * @author bor@zenexity.fr
 */
public interface ISmsService {

    void send(final String number, final String message)
        throws CvqException;

    boolean isEnabled();
}
