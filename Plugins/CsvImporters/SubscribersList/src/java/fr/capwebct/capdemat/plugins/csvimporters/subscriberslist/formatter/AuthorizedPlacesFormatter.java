package fr.capwebct.capdemat.plugins.csvimporters.subscriberslist.formatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import net.sf.anupam.csv.formatters.CSVFieldFormatter;

/**
 * A formatter that extracts authorized number of places for a given subscriber.
 * 
 * @csv.formatter-mapping name="authorizedPlaces"
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class AuthorizedPlacesFormatter implements CSVFieldFormatter {

    static Logger logger = Logger.getLogger(AuthorizedPlacesFormatter.class);

    public Object format(String value) {
        
        logger.debug("dealing with : " + value);
        
        if (value == null)
            return null;

        String trimmedValue = value.trim();
        
        Pattern pattern = Pattern.compile("(\\d+)(.*)");
        Matcher matcher = pattern.matcher(trimmedValue);
        if (matcher.find()) {
            String authorizedPlacesNumber = matcher.group(1).trim();
            logger.debug("group(1) : " + authorizedPlacesNumber);
            
            return Integer.valueOf(authorizedPlacesNumber);
        }
        
        return null;
    }
}
