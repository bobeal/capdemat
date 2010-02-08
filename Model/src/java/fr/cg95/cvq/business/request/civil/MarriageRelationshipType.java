package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
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
        for (MarriageRelationshipType value : allMarriageRelationshipTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultMarriageRelationshipType();
    }
}
