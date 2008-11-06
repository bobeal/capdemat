package fr.cg95.cvq.exception;

/**
 * Exception raised when a bad password is entered while trying to change an users's password.
 * 
 * @author bor@zenexity.fr
 */
public class CvqBadPasswordException extends CvqException {

    public CvqBadPasswordException(String reason, String key) {
        super(reason, key);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    public CvqBadPasswordException() {
        super();
    }

    public CvqBadPasswordException(String reason) {
        super(reason);
    }
}
