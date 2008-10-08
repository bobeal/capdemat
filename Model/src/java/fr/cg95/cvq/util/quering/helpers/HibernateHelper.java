package fr.cg95.cvq.util.quering.helpers;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

public class HibernateHelper {
    /**
     * Maps Java types to hibernate types
     * 
     * @param value param value
     * @return hibernate type
     */
    public static Type mapType(Object value) {
        if(value instanceof Integer)
            return Hibernate.INTEGER;
        else if (value instanceof Float)
            return Hibernate.FLOAT;
        else if (value instanceof Boolean)
            return Hibernate.BOOLEAN;
        else if (value instanceof Long)
            return Hibernate.LONG;
        else if (value instanceof Date)
            return Hibernate.TIMESTAMP;
        else if (value instanceof Double)
            return Hibernate.DOUBLE;
        else if (value instanceof Calendar)
            return Hibernate.CALENDAR;
        else if (value instanceof Short)
            return Hibernate.SHORT;
        else
            return Hibernate.STRING;
    }
}
