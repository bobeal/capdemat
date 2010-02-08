package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class DhrDwellingStatusType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final DhrDwellingStatusType OWNER = new DhrDwellingStatusType("owner");
  
    public static final DhrDwellingStatusType TENANT = new DhrDwellingStatusType("tenant");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrDwellingStatusType(String value) {
        super(value);
    }

    public DhrDwellingStatusType() {}

    public static DhrDwellingStatusType[] allDhrDwellingStatusTypes = {
        OWNER,
        TENANT
    };

    public static DhrDwellingStatusType getDefaultDhrDwellingStatusType() {
        return null;
    }

    public static DhrDwellingStatusType forString(final String enumAsString) {
        for (DhrDwellingStatusType value : allDhrDwellingStatusTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDhrDwellingStatusType();
    }
}
