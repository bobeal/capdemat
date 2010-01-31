package fr.cg95.cvq.service.payment;

import fr.cg95.cvq.exception.CvqException;

public class CvqInvalidBrokerException extends CvqException {

    private static final long serialVersionUID = 1L;

    public CvqInvalidBrokerException(final String key) {
        super(key);
    }
}
