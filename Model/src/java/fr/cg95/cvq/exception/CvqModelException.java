package fr.cg95.cvq.exception;

/**
 * Exception class used to raise business related exceptions.
 * 
 * @author bor@zenexity.fr
 */
public class CvqModelException extends CvqException {

    private static final long serialVersionUID = 1L;

    public CvqModelException(String key) {
        super(key);
    }

    public CvqModelException(String key, String[] args) {
        super(key, args);
    }
}
