package fr.cg95.cvq.exception;

/**
 * Exception raised when a functionality disabled by a configuration directive is invoked.
 *
 * @author bor@zenexity.fr
 */
public class CvqDisabledFunctionalityException extends CvqException {

    public CvqDisabledFunctionalityException(String reason, String key) {
        super(reason, key);
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 1L;

    public CvqDisabledFunctionalityException() {
        super();
    }

    public CvqDisabledFunctionalityException(String reason) {
        super(reason);
    }
}
