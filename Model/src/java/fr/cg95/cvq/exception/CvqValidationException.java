package fr.cg95.cvq.exception;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

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

    public String getMessage() {
        StringBuffer sb = new StringBuffer(super.getMessage());
        sb.append(" : ").append(StringUtils.join(invalidFields, " / "));
        return sb.toString();
    }
}
