package fr.capwebct.capdemat.plugins.csvimporters.concerto.formatter;

import net.sf.anupam.csv.formatters.CSVFieldFormatter;

/**
 * A formatter that removes trailing money designations from family quotient information.
 * 
 * @csv.formatter-mapping name="familyQuotient"
 * @author Benoit Orihuela (bor@zenexity.fr)
 * @deprecated
 */
public class FamilyQuotientFormatter implements CSVFieldFormatter {

    public Object format(String value) {
        
        if (value == null || value.equals(""))
            return value;
        
        return value.substring(0, value.lastIndexOf(' '));
    }

}
