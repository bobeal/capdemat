package fr.capwebct.capdemat.plugins.csvimporters.concerto.formatter;

import java.text.SimpleDateFormat;

import net.sf.anupam.csv.formatters.CSVFieldFormatter;

/**
 * A formatter that converts Concerto-formatted dates to a Date object.
 * 
 * @csv.formatter-mapping name="birthDate"
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class BirthDateFormatter implements CSVFieldFormatter {

    public Object format(String value) {
        
        if (value == null || value.equals("")) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            try {
                return sdf.parse(value);
            } catch (java.text.ParseException pe) {
                // hmm, worrying isn't it ?
            }
        }

        return null;
    }

}
