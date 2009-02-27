package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HccrSubjectParentalAuthorityHolderType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HccrSubjectParentalAuthorityHolderType FATHER = new HccrSubjectParentalAuthorityHolderType("Father");
    public static final HccrSubjectParentalAuthorityHolderType MOTHER = new HccrSubjectParentalAuthorityHolderType("Mother");
    public static final HccrSubjectParentalAuthorityHolderType OTHER = new HccrSubjectParentalAuthorityHolderType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HccrSubjectParentalAuthorityHolderType(String value) {
       super(value);
    }


    public HccrSubjectParentalAuthorityHolderType() {}



    public static HccrSubjectParentalAuthorityHolderType[] allHccrSubjectParentalAuthorityHolderTypes = {
        FATHER,
        MOTHER,
        OTHER
    };


    public static HccrSubjectParentalAuthorityHolderType getDefaultHccrSubjectParentalAuthorityHolderType() {
        return null;
    }


    public static HccrSubjectParentalAuthorityHolderType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHccrSubjectParentalAuthorityHolderType();

        if (enumAsString.equals(FATHER.toString()))
            return FATHER;
        else if (enumAsString.equals(MOTHER.toString()))
            return MOTHER;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultHccrSubjectParentalAuthorityHolderType();
    }
}
