package fr.cg95.cvq.exception;

/**
 * Exception raised when a functionality disabled by a configuration directive is invoked.
 *
 * @author bor@zenexity.fr
 */
public class CvqDisabledFunctionalityException extends CvqException {

    private static final long serialVersionUID = 1L;

    public CvqDisabledFunctionalityException() {
        super();
    }

    public CvqDisabledFunctionalityException(String key) {
        super(key);
    }
}
