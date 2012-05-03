package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class DayPeriodType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final DayPeriodType ALL_DAY = new DayPeriodType("allDay");
  
    public static final DayPeriodType HALF_DAY = new DayPeriodType("halfDay");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DayPeriodType(String value) {
        super(value);
    }

    public DayPeriodType() {}

    public static DayPeriodType[] allDayPeriodTypes = {
        ALL_DAY,
        HALF_DAY
    };

    public static DayPeriodType getDefaultDayPeriodType() {
        return ALL_DAY;
    }

    public static DayPeriodType forString(final String enumAsString) {
        for (DayPeriodType value : allDayPeriodTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDayPeriodType();
    }
}
