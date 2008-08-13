package fr.capwebct.capdemat.plugins.csvimporters.concerto.formatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.users.Address;
import net.sf.anupam.csv.formatters.CSVFieldFormatter;

/**
 * A formatter that converts one-field addresses designations into {@link Address} objects.
 * 
 * @csv.formatter-mapping name="address"
 * @author Benoit Orihuela (bor@zenexity.fr)
 * @fixme : why is it called four times for each CSV line ??
 */
public class AddressFormatter implements CSVFieldFormatter {

    static Logger logger = Logger.getLogger(AddressFormatter.class);

    public Object format(String value) {
        
//        logger.debug("dealing with : " + value);
        
        if (value == null)
            return null;
        // TODO Better refactor this, to respect Address Normalisation
        Pattern pattern = Pattern.compile("(\\d{1,5}?)(.*)(\\d{5})(.*)");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            String streetNumber = matcher.group(1);
            String streetName = matcher.group(2).trim();
            String postalCode = matcher.group(3);
            String city = matcher.group(4).trim();
//            logger.debug("group(1) : " + addressLine);
//            logger.debug("group(2) : " + postalCode);
//            logger.debug("group(3) : " + city);
            Address address = new Address(streetNumber,streetName, postalCode, city);
            return address;
        }
        
        return null;
    }

}
