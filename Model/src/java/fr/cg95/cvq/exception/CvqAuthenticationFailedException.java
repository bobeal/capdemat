package fr.cg95.cvq.exception;

/**
 * Exception raised when an authentication failed.
 * 
 * @author bor@zenexity.fr
 */
public class CvqAuthenticationFailedException extends CvqException {

    private static final long serialVersionUID = 1L;

    public CvqAuthenticationFailedException(final String key) {
        super(key);
    }
}
