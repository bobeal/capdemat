package fr.cg95.cvq.exception;

/**
 * Exception raised when someone tries to log in into a disabled account.
 * 
 * @author bor@zenexity.fr
 */
public class CvqDisabledAccountException extends CvqException {

    public CvqDisabledAccountException(String reason, String key) {
        super(reason, key);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    public CvqDisabledAccountException() {
        super();
    }

    public CvqDisabledAccountException(final String reason) {
        super(reason);
    }
}
