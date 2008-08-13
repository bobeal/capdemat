package fr.capwebct.modules.payment.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    
    public static Date processDate(final String inputStringDate) 
        throws ParseException{

        if (inputStringDate == null || inputStringDate.trim().equals("")) {
            return null;
        } else {
            return dateFormat.parse(inputStringDate);
        }
    }
        

}
