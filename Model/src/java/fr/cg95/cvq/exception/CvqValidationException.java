package fr.cg95.cvq.exception;

public class CvqValidationException extends CvqModelException {

    public CvqValidationException() {
        super("model validation failed");
    }

    private static final long serialVersionUID = 1L;
}
