package fr.capwebct.capdemat.plugins.csvimporters.concerto.formatter;

import fr.cg95.cvq.business.users.SexType;
import net.sf.anupam.csv.formatters.CSVFieldFormatter;

/**
 * A formatter that converts sex designations into {@link SexType} objects.
 * 
 * @csv.formatter-mapping name="sexType"
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class SexTypeFormatter implements CSVFieldFormatter {

    public Object format(String value) {

        if (value == null)
            return SexType.UNKNOWN;
         
        if (value.equals("Garon") || value.equals("Garçon") || value.startsWith("Gar"))
            return SexType.MALE;
        else if (value.equals("Fille"))
            return SexType.FEMALE;

        return SexType.UNKNOWN;
    }
}
