package fr.capwebct.modules.payment.business.csv.formatters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.anupam.csv.formatters.CSVFieldFormatter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ValueFormatter  implements CSVFieldFormatter {

    private static Log log = LogFactory.getLog(ValueFormatter.class);

    public Object format(String value) {
        
        log.debug("dealing with : " + value);
        
        if (value == null)
            return null;

        String trimmedValue = value.trim();
        
        Pattern pattern = Pattern.compile("(\\-?\\d+)(.*)");
        Matcher matcher = pattern.matcher(trimmedValue);
        if (matcher.find()) {
            String formattedValue = matcher.group(1).trim();
            log.debug("group(1) : " + formattedValue);
            
            return Integer.valueOf(formattedValue);
        }
        
        return null;
    }

}
