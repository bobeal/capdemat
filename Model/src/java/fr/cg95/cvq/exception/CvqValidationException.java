package fr.cg95.cvq.exception;

import java.util.List;

public class CvqValidationException extends CvqModelException {

    private static final long serialVersionUID = 1L;

    public CvqValidationException(String key) {
        super(key);
    }

    public CvqValidationException(List<String> invalidFields) {
        super("error.validation.hasInvaliedFields");
        this.invalidFields = invalidFields;
    }

    public List<String> invalidFields;

}
