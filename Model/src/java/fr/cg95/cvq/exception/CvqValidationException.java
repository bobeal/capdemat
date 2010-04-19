package fr.cg95.cvq.exception;

import java.util.List;
import java.util.Map;

public class CvqValidationException extends CvqModelException {

    private static final long serialVersionUID = 1L;

    private Map<String, List<String>> invalidFields;

    public CvqValidationException(Map<String, List<String>> invalidFields) {
        super("model validation failed");
        this.invalidFields = invalidFields;
    }

    public Map<String, List<String>> getInvalidFields() {
        return invalidFields;
    }
}
