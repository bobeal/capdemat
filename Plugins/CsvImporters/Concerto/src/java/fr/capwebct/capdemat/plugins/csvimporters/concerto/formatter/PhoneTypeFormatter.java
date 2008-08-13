package fr.capwebct.capdemat.plugins.csvimporters.concerto.formatter;

import net.sf.anupam.csv.formatters.CSVFieldFormatter;

/**
 * A formatter that converts dot-delimited phone numbers into CapDémat formatted strings.
 * 
 * @csv.formatter-mapping name="phoneType"
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class PhoneTypeFormatter implements CSVFieldFormatter {

    public Object format(String value) {

        if (value == null || value.equals(""))
            return null;

        return value.replaceAll("\\.", "");
    }
}
