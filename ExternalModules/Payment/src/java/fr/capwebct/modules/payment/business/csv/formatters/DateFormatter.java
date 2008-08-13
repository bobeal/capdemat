package fr.capwebct.modules.payment.business.csv.formatters;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import net.sf.anupam.csv.formatters.CSVFieldFormatter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateFormatter  implements CSVFieldFormatter {

    private static Log log = LogFactory.getLog(DateFormatter.class);

    private static SimpleDateFormat dateFormatWithSeconds =
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    private static SimpleDateFormat dateFormat =
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    
    public Object format(String value) {
        
        log.debug("dealing with : " + value);
        
        if (value == null || value.equals(""))
            return null;

        String trimmedValue = value.trim();
        try {
            return dateFormatWithSeconds.parse(trimmedValue);
        } catch (ParseException pe) {
            try {
                return dateFormat.parseObject(trimmedValue);
            } catch (ParseException pe2) {
                return null;
            }
        }
    }
}
