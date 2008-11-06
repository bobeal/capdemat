package fr.cg95.cvq.exception;

/**
 * Exception raised when an object is found in DB but was not expected to.
 *
 * @author bor@zenexity.fr
 */
public class CvqObjectAlreadyExistsException extends CvqException {

    private static final long serialVersionUID = 1L;

    public CvqObjectAlreadyExistsException() {
        super();
    }

    public CvqObjectAlreadyExistsException(final String reason) {
        super(reason);
    }

    public CvqObjectAlreadyExistsException(String reason, String key) {
        super(reason, key);
        // TODO Auto-generated constructor stub
    }
}
