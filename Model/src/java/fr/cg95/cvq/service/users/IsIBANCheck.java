package fr.cg95.cvq.service.users;

import java.math.BigDecimal;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;

public class IsIBANCheck extends AbstractAnnotationCheck<IsIBAN> {

    private static final long serialVersionUID = 1L;

    private static final BigDecimal ibanCheckingConstant = new BigDecimal(97);

    @Override
    public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context,
        Validator validator) throws OValException {
        if (valueToValidate == null) return true;
        String iban = (String)valueToValidate;
        if (iban.length() < 4) return false;
        StringBuffer sbIban = new StringBuffer(iban.substring(4));
        sbIban.append(iban.substring(0, 4));
        iban = sbIban.toString();
        StringBuilder extendedIban = new StringBuilder(iban.length());
        for (char currentChar : iban.toCharArray()) {
            extendedIban.append(Character.digit(currentChar,Character.MAX_RADIX));
        }
        return new BigDecimal(extendedIban.toString()).remainder(ibanCheckingConstant).intValue() == 1;
    }
}
