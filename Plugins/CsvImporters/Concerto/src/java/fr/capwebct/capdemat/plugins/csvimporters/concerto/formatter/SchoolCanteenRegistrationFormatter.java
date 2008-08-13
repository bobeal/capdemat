package fr.capwebct.capdemat.plugins.csvimporters.concerto.formatter;

import net.sf.anupam.csv.formatters.CSVFieldFormatter;

/**
 * A formatter that, according to the value of the field, tells whether current child
 * is registered to school canteen.
 * 
 * @csv.formatter-mapping name="schoolCanteenRegistration"
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class SchoolCanteenRegistrationFormatter implements CSVFieldFormatter {

    public Object format(String value) {

        if (value == null)
            return Boolean.FALSE;
        
        if (value.equals("Restauration Scolaire"))
            return Boolean.TRUE;
        
        return Boolean.FALSE;
    }

}
