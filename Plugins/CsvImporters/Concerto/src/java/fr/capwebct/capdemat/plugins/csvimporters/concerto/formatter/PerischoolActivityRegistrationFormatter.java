package fr.capwebct.capdemat.plugins.csvimporters.concerto.formatter;

import net.sf.anupam.csv.formatters.CSVFieldFormatter;

/**
 * A formatter that, according to the value of the field, tells whether current child
 * is registered to perischool activity.
 * 
 * @csv.formatter-mapping name="perischoolActivityRegistration"
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class PerischoolActivityRegistrationFormatter implements CSVFieldFormatter {

    public Object format(String value) {

        if (value == null)
            return Boolean.FALSE;
        
        if (value.equals("Garderie"))
            return Boolean.TRUE;
        
        return Boolean.FALSE;
    }
}
