package fr.cg95.cvq.payment;

import fr.cg95.cvq.exception.CvqException;

public class CvqInvalidBrokerException extends CvqException {

    private static final long serialVersionUID = 1L;

    public CvqInvalidBrokerException() {
        super();
    }
    
    public CvqInvalidBrokerException(final String reason) {
        super(reason);
    }
}
