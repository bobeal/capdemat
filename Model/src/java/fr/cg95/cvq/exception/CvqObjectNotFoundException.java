package fr.cg95.cvq.exception;

/**
 * Exception raised when an object is not found in DB and was expected to.
 *
 * @author bor@zenexity.fr
 */
public class CvqObjectNotFoundException extends CvqException {

    public CvqObjectNotFoundException(String reason, String key) {
        super(reason, key);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    public CvqObjectNotFoundException() {
        super();
    }

    public CvqObjectNotFoundException(final String reason) {
        super(reason);
    }
}
