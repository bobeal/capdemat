package fr.cg95.cvq.util;

import java.util.Collection;
import java.util.Date;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Utility class used to pass criteria search parameters between the presentation layer
 * and the business layer.
 *
 * @author bor@zenexity.fr
 */
public class Critere {

    public static final String EQUALS = "="; /* for search among select lists */
    public static final String IEQUALS = "i="; /* unused */
    public static final String NEQUALS = "!="; /* only to exclude archived requests from search results */
    public static final String LIKE = "LIKE"; /* unused */
    public static final String STARTSWITH = "STARTSWITH"; /* for search among free input texts */
    public static final String GT = ">"; /* unused */ 
    public static final String LT = "<"; /* unused */
    public static final String GTE = ">="; /* only for dates */
    public static final String LTE = "<="; /* only for dates */
    public static final String IN = "in"; /* value must be an instanceof Collection */
    public static final String NIN = "not in"; /* value must be an instanceof Collection  */

    /** Search criteria */
    private String attribut;

    /**
     * Value for the attribute. Currently supported types are String, Long and Date
     */
    private Object value;

    /** Comparison criteria */
    private String comparatif;

    public Critere() {
        // empty constructor for Hibernate
    }

    public Critere(String attribut, Object value, String comparatif) {
        this.attribut = attribut;
        this.value = value;
        this.comparatif = comparatif;
    }

    public static Criterion compose(String attribute, Object value, String comparator) {
        
        if (EQUALS.equals(comparator))
            return Restrictions.eq(attribute,value);
        else if (IEQUALS.equals(comparator))
            return Restrictions.eq(attribute,value).ignoreCase();
        else if (NEQUALS.equals(comparator))
            return Restrictions.or(Restrictions.gt(attribute,value),
                    Restrictions.lt(attribute,value));
        else if (LIKE.equals(comparator))
            return Restrictions.like(attribute,"%"+value+"%");
        else if (STARTSWITH.equals(comparator))
            return Restrictions.like(attribute,value+"%").ignoreCase();
        else if (GT.equals(comparator))
            return Restrictions.gt(attribute,value);
        else if (GTE.equals(comparator))
            return Restrictions.ge(attribute,value);
        else if (LT.equals(comparator))
            return Restrictions.lt(attribute,value);
        else if (LTE.equals(comparator))
            return Restrictions.le(attribute,value);
        else if (IN.equals(comparator))
            return Restrictions.in(attribute, (Collection<?>)value);
        else if (NIN.equals(comparator))
            return Restrictions.not(Restrictions.in(attribute, (Collection<?>)value));

        // default comparator
        return Restrictions.eq(attribute,value);
    }

    public Criterion compose() {
        return compose(attribut, value, comparatif);
    }

    public String getAttribut() {
        return attribut;
    }

    public void setAttribut(String attribut) {
        this.attribut = attribut;
    }

    public String getComparatif() {
        return comparatif;
    }

    public String getSqlComparatif() {
        if (EQUALS.equals(comparatif))
            return "=";
        else if (IEQUALS.equals(comparatif))
            return "~=";
        else if (NEQUALS.equals(comparatif))
            return "!=";
        else if (LIKE.equals(comparatif))
            return "like";
        else if (STARTSWITH.equals(comparatif))
            return "like";
        else if (GT.equals(comparatif))
            return ">";
        else if (GTE.equals(comparatif))
            return ">=";
        else if (LT.equals(comparatif))
            return "<";
        else if (LTE.equals(comparatif))
            return "<=";

        // default comparator
        return "=";
    }

    public void setComparatif(String comparatif) {
        this.comparatif = comparatif;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    /**
     * Return the value represented by this criteria as a String object.
     *
     * @return null if value represented by this criteria cannot be converted to a String object
     */
    public String getStringValue() {
        if (!(value instanceof String))
            return null;
        else
            return (String) value;
    }

    /**
     * Return the value represented by this criteria as a String object, eventually decorated
     * with SQL keywords for LIKE-style comparisons.
     *
     * @return null if value represented by this criteria cannot be converted to a String object
     */
    public String getSqlStringValue() {
        String stringValue = getStringValue();
        if (stringValue == null)
            return null;

        if (LIKE.equals(comparatif))
            return "%" + stringValue + "%";
        else if (STARTSWITH.equals(comparatif))
            return stringValue + "%";
        else
            return stringValue;
    }

    /**
     * Return the value represented by this criteria as a Date object.
     *
     * @return null if value represented by this criteria cannot be converted to a Date object
     */
    public Date getDateValue() {
        if (!(value instanceof Date))
            return null;
        else
            return (Date) value;
    }

    /**
     * Return the value represented by this criteria as a Long object.
     *
     * @return null if value represented by this criteria cannot be converted to a Long object
     */
    public Long getLongValue() {
        if (value instanceof Long)
            return (Long) value;
        else if (value instanceof String) {
            try {
                return new Long((String) value);
            } catch (Exception e) {
                return null;
            }
        }
        else
            return null;
    }
}
