package fr.capwebct.modules.payment.exception;

public class CpmWebServiceException extends Exception {

    private static final long serialVersionUID = 1L;

    public CpmWebServiceException() {
        super();
    }
    
    public CpmWebServiceException(final String reason) {
        super(reason);
    }
}
