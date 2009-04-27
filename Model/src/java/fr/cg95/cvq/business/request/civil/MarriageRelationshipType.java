package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.civil.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class MarriageRelationshipType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final MarriageRelationshipType HUSBAND = new MarriageRelationshipType("Husband");
    public static final MarriageRelationshipType WIFE = new MarriageRelationshipType("Wife");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private MarriageRelationshipType(String value) {
       super(value);
    }


    public MarriageRelationshipType() {}



    public static MarriageRelationshipType[] allMarriageRelationshipTypes = {
        HUSBAND,
        WIFE
    };


    public static MarriageRelationshipType getDefaultMarriageRelationshipType() {
        return null;
    }


    public static MarriageRelationshipType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultMarriageRelationshipType();

        if (enumAsString.equals(HUSBAND.toString()))
            return HUSBAND;
        else if (enumAsString.equals(WIFE.toString()))
            return WIFE;

        return getDefaultMarriageRelationshipType();
    }
}
