import java.text.SimpleDateFormat
import java.text.ParseException

public class DateUtils {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
    private static SimpleDateFormat sdf2  = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static stringToDate(String date) {
        try {
            return sdf.parse(date)
        } catch (ParseException pe) {
            return ""
        }
    }
    
    public static formatDate(Date date) {
        try {
            return sdf2.format(date);
        } catch (ParseException pe) {
            return ""
        }
    }
  
}