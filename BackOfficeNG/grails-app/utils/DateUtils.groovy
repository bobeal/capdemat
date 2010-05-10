import fr.cg95.cvq.security.SecurityContext

import java.text.SimpleDateFormat
import java.text.ParseException

public class DateUtils {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
    private static SimpleDateFormat systemSdf = new SimpleDateFormat("yyyy-MM-dd")

    public static stringToDate(String date) {
        try {
            return sdf.parse(date)
        } catch (ParseException pe) {
            return null
        } catch (Exception e) {
            return null
        }
    }
    
    public static systemStringToDate(String date) {
        try {
            return systemSdf.parse(date)
        } catch (ParseException pe) {
            return null
        }
    }
		
    public static dateToShortString(Date date) {
        return sdf.format(date)
    }

    public static dateToFullString(Date date) {
        return new SimpleDateFormat("dd MMMM yyyy", SecurityContext.currentLocale).format(date)
    }
}
