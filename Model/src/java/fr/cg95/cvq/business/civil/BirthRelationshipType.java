package fr.cg95.cvq.business.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class BirthRelationshipType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final BirthRelationshipType HUSBAND = new BirthRelationshipType("Husband");
    public static final BirthRelationshipType WIFE = new BirthRelationshipType("Wife");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private BirthRelationshipType(String value) {
       super(value);
    }


    public BirthRelationshipType() {}



    public static BirthRelationshipType getDefaultBirthRelationshipType() {
        return HUSBAND;
    }


    public static BirthRelationshipType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultBirthRelationshipType();

        if (enumAsString.equals(HUSBAND.toString()))
            return HUSBAND;
        else if (enumAsString.equals(WIFE.toString()))
            return WIFE;

        return getDefaultBirthRelationshipType();
    }
}
