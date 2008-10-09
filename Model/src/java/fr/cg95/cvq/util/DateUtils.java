package fr.cg95.cvq.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

	public static int getWorkDaysBetweenDates(Date startDate, Date endDate) {
		Calendar startCalendar = GregorianCalendar.getInstance();
		startCalendar.setTime(startDate);
		Calendar endCalendar = GregorianCalendar.getInstance();
		endCalendar.setTime(endDate);
		int finalWorkDays = 0;
		while (startCalendar.before(endCalendar)) {
			startCalendar.add(Calendar.DAY_OF_YEAR, 1);
			if (startCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCalendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
				finalWorkDays++;
		}
		
		return finalWorkDays;
	}
    
    public static String format(Date date) {
        return dateFormat.format(date);
    }
    
    public static Date parseDate(String source) throws ParseException {
       return dateFormat.parse(source);
    }
    
    public static Date getShiftedDate(int shiftUnit, int shiftAmount) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(shiftUnit, shiftAmount);
        
        return calendar.getTime();
    }
}
