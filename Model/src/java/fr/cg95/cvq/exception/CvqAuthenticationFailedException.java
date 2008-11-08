package fr.cg95.cvq.exception;

/**
 * Exception raised when an authentication failed.
 * 
 * @author bor@zenexity.fr
 */
public class CvqAuthenticationFailedException extends CvqException {

    public CvqAuthenticationFailedException(String reason, String key) {
        super(reason, key);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    public CvqAuthenticationFailedException() {
        super();
    }

    public CvqAuthenticationFailedException(final String reason) {
        super(reason);
    }
}
