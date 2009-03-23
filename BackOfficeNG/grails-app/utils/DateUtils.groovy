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
}
