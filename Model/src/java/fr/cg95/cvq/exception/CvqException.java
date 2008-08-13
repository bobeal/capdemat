package fr.cg95.cvq.exception;

/**
 * Base class for application's checked exceptions class hierarchy.
 *
 * @author bor@zenexity.fr
 */
public class CvqException extends Exception {

    private static final long serialVersionUID = 1L;

    public CvqException() {
        super();
    }

    public CvqException(final String reason) {
        super(reason);
    }
}
