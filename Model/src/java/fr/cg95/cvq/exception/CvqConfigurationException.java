package fr.cg95.cvq.exception;

/**
 * Exception class used to raise configuration exceptions.
 * 
 * @author bor@zenexity.fr
 */
public class CvqConfigurationException extends CvqException {

    private static final long serialVersionUID = 1L;

    public CvqConfigurationException() {
        super();
    }

    public CvqConfigurationException(String reason) {
        super(reason);
    }
}
