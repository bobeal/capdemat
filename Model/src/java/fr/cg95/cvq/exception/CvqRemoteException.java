package fr.cg95.cvq.exception;

/**
 * Exception class raised when a remote component is unavailable.
 *
 * @author bor@zenexity.fr
 */
public class CvqRemoteException extends CvqException {

    private static final long serialVersionUID = 1L;

    public CvqRemoteException() {
        super();
    }

    public CvqRemoteException(final String reason) {
        super(reason);
    }
}
