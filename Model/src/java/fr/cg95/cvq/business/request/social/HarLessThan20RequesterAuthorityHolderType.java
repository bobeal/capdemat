package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class HarLessThan20RequesterAuthorityHolderType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarLessThan20RequesterAuthorityHolderType FATHER = new HarLessThan20RequesterAuthorityHolderType("father");
    public static final HarLessThan20RequesterAuthorityHolderType MOTHER = new HarLessThan20RequesterAuthorityHolderType("mother");
    public static final HarLessThan20RequesterAuthorityHolderType OTHER = new HarLessThan20RequesterAuthorityHolderType("other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarLessThan20RequesterAuthorityHolderType(String value) {
       super(value);
    }


    public HarLessThan20RequesterAuthorityHolderType() {}



    public static HarLessThan20RequesterAuthorityHolderType[] allHarLessThan20RequesterAuthorityHolderTypes = {
        FATHER,
        MOTHER,
        OTHER
    };


    public static HarLessThan20RequesterAuthorityHolderType getDefaultHarLessThan20RequesterAuthorityHolderType() {
        return null;
    }


    public static HarLessThan20RequesterAuthorityHolderType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarLessThan20RequesterAuthorityHolderType();

        if (enumAsString.equals(FATHER.toString()))
            return FATHER;
        else if (enumAsString.equals(MOTHER.toString()))
            return MOTHER;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultHarLessThan20RequesterAuthorityHolderType();
    }
}
