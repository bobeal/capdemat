package fr.capwebct.capdemat.plugins.csvimporters.concerto.formatter;

import fr.cg95.cvq.business.users.TitleType;
import net.sf.anupam.csv.formatters.CSVFieldFormatter;

/**
 * A formatter that converts titles designations into {@link TitleType} objects.
 * 
 * @csv.formatter-mapping name="titleType"
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class TitleTypeFormatter implements CSVFieldFormatter {

    public Object format(String value) {

        if (value == null)
            return TitleType.UNKNOWN;
        
        if (value.equals("Madame"))
            return TitleType.MADAM;
        else if (value.equals("Monsieur"))
            return TitleType.MISTER;
        
        return TitleType.UNKNOWN;
    }

}
