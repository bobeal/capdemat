package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class RsrContactKindType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final RsrContactKindType REQUESTER = new RsrContactKindType("Requester");
  
    public static final RsrContactKindType OTHER = new RsrContactKindType("Other");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private RsrContactKindType(String value) {
        super(value);
    }

    public RsrContactKindType() {}

    public static RsrContactKindType[] allRsrContactKindTypes = {
        REQUESTER,
        OTHER
    };

    public static RsrContactKindType getDefaultRsrContactKindType() {
        return REQUESTER;
    }

    public static RsrContactKindType forString(final String enumAsString) {
        for (RsrContactKindType value : allRsrContactKindTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultRsrContactKindType();
    }
}
