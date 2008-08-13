package fr.cg95.cvq.exception;

/**
 * Exception thrown when one tries to perform an illegal state change.
 *
 * @author bor@zenexity.fr
 */
public class CvqInvalidTransitionException extends CvqException {

    private static final long serialVersionUID = 1L;

    public CvqInvalidTransitionException() {
        super();
    }

    public CvqInvalidTransitionException(String reason) {
        super(reason);
    }
}
