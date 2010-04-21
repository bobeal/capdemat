package fr.cg95.cvq.service.users;

import java.math.BigDecimal;

import fr.cg95.cvq.business.users.FrenchRIB;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;

public class IsFrenchRIBCheck extends AbstractAnnotationCheck<IsFrenchRIB> {

    private static final long serialVersionUID = 1L;

    @Override
    public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context,
        Validator validator) throws OValException {
        if (validatedObject == null) return true;
        String rib = ((FrenchRIB)validatedObject).format();
        StringBuilder extendedRib = new StringBuilder(rib.length());
        for (char currentChar : rib.toCharArray()) {
            //Works on base 36
            int currentCharValue = Character.digit(currentChar, Character.MAX_RADIX);
            //Convert character to simple digit
            extendedRib.append(currentCharValue < 10 ? currentCharValue :
                (currentCharValue + (int) StrictMath.pow(2, (currentCharValue - 10) / 9)) % 10);
        }
        return new BigDecimal(extendedRib.toString()).remainder(new BigDecimal(97)).intValue() == 0;
    }
}
