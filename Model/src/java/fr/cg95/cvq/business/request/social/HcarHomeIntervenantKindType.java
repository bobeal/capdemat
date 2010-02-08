package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class HcarHomeIntervenantKindType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final HcarHomeIntervenantKindType CARER = new HcarHomeIntervenantKindType("Carer");
  
    public static final HcarHomeIntervenantKindType HOME_HELP = new HcarHomeIntervenantKindType("HomeHelp");
  
    public static final HcarHomeIntervenantKindType OTHER = new HcarHomeIntervenantKindType("Other");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HcarHomeIntervenantKindType(String value) {
        super(value);
    }

    public HcarHomeIntervenantKindType() {}

    public static HcarHomeIntervenantKindType[] allHcarHomeIntervenantKindTypes = {
        CARER,
        HOME_HELP,
        OTHER
    };

    public static HcarHomeIntervenantKindType getDefaultHcarHomeIntervenantKindType() {
        return null;
    }

    public static HcarHomeIntervenantKindType forString(final String enumAsString) {
        for (HcarHomeIntervenantKindType value : allHcarHomeIntervenantKindTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHcarHomeIntervenantKindType();
    }
}
