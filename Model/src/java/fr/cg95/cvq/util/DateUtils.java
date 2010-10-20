package fr.cg95.cvq.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

public class DateUtils {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

    private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

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

    public static String formatDate(Date date) {
        if (date == null)
            return "";
        // create a date formatter
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.FRANCE);

        return df.format(date);
    }

    public static Date parseDateTime(String source) throws ParseException {
        return dateTimeFormat.parse(source);
     }

    public static Date getShiftedDate(int shiftUnit, int shiftAmount) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(shiftUnit, shiftAmount);
        
        return calendar.getTime();
    }

    public static Date getShiftedDate(Date reference, int shiftUnit, int shiftAmount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(reference);
        calendar.add(shiftUnit, shiftAmount);
        return calendar.getTime();
    }

    public static Date setTime(Date date, String hours, String minutes) {
        if (date == null)
            return null;
        DateTime dateTime = new DateTime(date);
        dateTime = dateTime.withHourOfDay("".equals(hours) ? 0 : new Integer(hours));
        dateTime = dateTime.withMinuteOfHour("".equals(minutes) ? 0 : new Integer(minutes));
        return dateTime.toDate();
    }

    /**
     * Parses a date from the given text from the format : yyyy-MM-dd'T'HH:mm:ss.SSS
     * Return null if the string is empty or null
     */
    public static Date parseIso(String date) {
        if (date == null || date.isEmpty())
            return null;
        return ISODateTimeFormat.dateHourMinuteSecondFraction().parseDateTime(date).toDate();
    }
}
