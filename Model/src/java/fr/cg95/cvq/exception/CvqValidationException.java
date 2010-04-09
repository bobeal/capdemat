package fr.cg95.cvq.exception;

import java.util.List;

public class CvqValidationException extends CvqModelException {

    private static final long serialVersionUID = 1L;

    private List<String> invalidFields;

    public CvqValidationException(List<String> invalidFields) {
        super("model validation failed");
        this.invalidFields = invalidFields;
    }

    public List<String> getInvalidFields() {
        return invalidFields;
    }
}
