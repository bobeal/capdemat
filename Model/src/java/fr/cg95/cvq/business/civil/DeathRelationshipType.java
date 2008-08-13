package fr.cg95.cvq.business.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class DeathRelationshipType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DeathRelationshipType HUSBAND = new DeathRelationshipType("Husband");
    public static final DeathRelationshipType WIFE = new DeathRelationshipType("Wife");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DeathRelationshipType(String value) {
       super(value);
    }


    public DeathRelationshipType() {}



    public static DeathRelationshipType getDefaultDeathRelationshipType() {
        return HUSBAND;
    }


    public static DeathRelationshipType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDeathRelationshipType();

        if (enumAsString.equals(HUSBAND.toString()))
            return HUSBAND;
        else if (enumAsString.equals(WIFE.toString()))
            return WIFE;

        return getDefaultDeathRelationshipType();
    }
}
