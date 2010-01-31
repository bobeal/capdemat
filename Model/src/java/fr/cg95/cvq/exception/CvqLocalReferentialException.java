package fr.cg95.cvq.exception;

/**
 * Exception class used to raise XML exceptions while manipulating local referential data.
 * 
 * @author bor@zenexity.fr
 */
public class CvqLocalReferentialException extends CvqException {

    private static final long serialVersionUID = 1L;

    public CvqLocalReferentialException() {
        super();
    }

    public CvqLocalReferentialException(String key) {
        super(key);
    }
}
