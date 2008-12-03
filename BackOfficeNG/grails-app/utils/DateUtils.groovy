import java.text.SimpleDateFormat
import java.text.ParseException
import java.lang.IllegalArgumentException

public class DateUtils {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
    private static SimpleDateFormat systemSdf = new SimpleDateFormat("yyyy-MM-dd")
    private static SimpleDateFormat sdf2  = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static stringToDate(String date) {
        try {
            return sdf.parse(date)
        } catch (ParseException pe) {
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
    
    public static formatShortDate(Date date) {
        if(date == null) return ''
        try {
            return sdf.format(date);
        } catch (ParseException pe) {
            return ""
        }
    }

    public static formatDate(Date date) {
        if(date == null) return ''
        try {
            return sdf2.format(date);
        } catch (ParseException pe) {
            return ""
        }
    }
  
}
