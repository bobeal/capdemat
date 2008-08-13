package fr.cg95.cvq.wizard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
    private static SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("dd/MM/yyyy à HH:mm", Locale.FRANCE);

    public static String parseDate(Calendar pDate) {
        return simpleDateFormat.format(pDate.getTime());
    }

    public static String parseDate(Date pDate) {
        return simpleDateFormat.format(pDate);
    }

    public static Calendar parseDate(String pStrDate) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(simpleDateFormat.parse(pStrDate));

        return calendar;
    }

    public static String parseDateTime(Calendar pDate) {
        return simpleDateTimeFormat.format(pDate.getTime());
    }

    public static String parseDateTime(Date pDate) {
        return simpleDateTimeFormat.format(pDate);
    }

    public static Calendar parseDateTime(String pStrDate) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(simpleDateTimeFormat.parse(pStrDate));

        return calendar;
    }

    public static String getYear() {
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }
}
