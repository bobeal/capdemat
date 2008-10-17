package fr.cg95.cvq.business.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class HarLessThan20ParentalAuthorityHolderType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarLessThan20ParentalAuthorityHolderType FATHER = new HarLessThan20ParentalAuthorityHolderType("Father");
    public static final HarLessThan20ParentalAuthorityHolderType MOTHER = new HarLessThan20ParentalAuthorityHolderType("Mother");
    public static final HarLessThan20ParentalAuthorityHolderType OTHER = new HarLessThan20ParentalAuthorityHolderType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarLessThan20ParentalAuthorityHolderType(String value) {
       super(value);
    }


    public HarLessThan20ParentalAuthorityHolderType() {}



    public static HarLessThan20ParentalAuthorityHolderType getDefaultHarLessThan20ParentalAuthorityHolderType() {
        return null;
    }


    public static HarLessThan20ParentalAuthorityHolderType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarLessThan20ParentalAuthorityHolderType();

        if (enumAsString.equals(FATHER.toString()))
            return FATHER;
        else if (enumAsString.equals(MOTHER.toString()))
            return MOTHER;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultHarLessThan20ParentalAuthorityHolderType();
    }
}
