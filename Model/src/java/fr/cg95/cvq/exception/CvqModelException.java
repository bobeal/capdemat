package fr.cg95.cvq.exception;

/**
 * Exception class used to raise business related exceptions.
 * 
 * @author bor@zenexity.fr
 */
public class CvqModelException extends CvqException {

    private static final long serialVersionUID = 1L;

    public CvqModelException(String reason) {
        super(reason);
    }

    public CvqModelException(String reason, String key) {
        super(reason, key);
    }
    
    public CvqModelException(String key, String[] args) {
        super(key, key, args);
    }
}
