package fr.capwebct.modules.payment.exception;

public class CpmParsingException extends Exception {

    private static final long serialVersionUID = 1L;

    public CpmParsingException() {
        super();
    }
    
    public CpmParsingException(final String reason) {
        super(reason);
    }
}
