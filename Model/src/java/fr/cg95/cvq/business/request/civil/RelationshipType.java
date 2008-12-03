package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.civil.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class RelationshipType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final RelationshipType HUSBAND = new RelationshipType("Husband");
    public static final RelationshipType WIFE = new RelationshipType("Wife");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RelationshipType(String value) {
       super(value);
    }


    public RelationshipType() {}



    public static RelationshipType[] allRelationshipTypes = {
        HUSBAND,
        WIFE
    };


    public static RelationshipType getDefaultRelationshipType() {
        return HUSBAND;
    }


    public static RelationshipType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultRelationshipType();

        if (enumAsString.equals(HUSBAND.toString()))
            return HUSBAND;
        else if (enumAsString.equals(WIFE.toString()))
            return WIFE;

        return getDefaultRelationshipType();
    }
}
