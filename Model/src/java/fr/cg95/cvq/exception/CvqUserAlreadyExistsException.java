package fr.cg95.cvq.exception;

/**
 * Exception raised when trying to provision an already existing user.
 *
 * @author bor@zenexity.fr
 */
public class CvqUserAlreadyExistsException extends CvqException {

    private static final long serialVersionUID = 1L;

    public CvqUserAlreadyExistsException() {
        super();
    }

    public CvqUserAlreadyExistsException(final String key) {
        super(key);
    }
}
