package fr.capwebct.capdemat.plugins.csvimporters.concerto.formatter;

import fr.cg95.cvq.business.authority.SectionType;
import net.sf.anupam.csv.formatters.CSVFieldFormatter;

/**
 * A formatter that converts school section designations into {@link SectionType} objects.
 * 
 * @csv.formatter-mapping name="sectionType"
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class SectionTypeFormatter implements CSVFieldFormatter {

    public Object format(String value) {

        if (value == null || value.equals(""))
            return SectionType.UNKNOWN;
        
        if (value.equals("TPS"))
            return SectionType.BEFORE_FIRST_SECTION;
        else if (value.equals("PS"))
            return SectionType.FIRST_SECTION;
        else if (value.equals("MS"))
            return SectionType.SECOND_SECTION;
        else if (value.equals("GS"))
            return SectionType.THIRD_SECTION;
        else 
            return SectionType.forString(value);
    }
}
