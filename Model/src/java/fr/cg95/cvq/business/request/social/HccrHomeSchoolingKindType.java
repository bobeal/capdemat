package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class HccrHomeSchoolingKindType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final HccrHomeSchoolingKindType ALONE = new HccrHomeSchoolingKindType("Alone");
  
    public static final HccrHomeSchoolingKindType ACCOMPANIED = new HccrHomeSchoolingKindType("Accompanied");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HccrHomeSchoolingKindType(String value) {
        super(value);
    }

    public HccrHomeSchoolingKindType() {}

    public static HccrHomeSchoolingKindType[] allHccrHomeSchoolingKindTypes = {
        ALONE,
        ACCOMPANIED
    };

    public static HccrHomeSchoolingKindType getDefaultHccrHomeSchoolingKindType() {
        return null;
    }

    public static HccrHomeSchoolingKindType forString(final String enumAsString) {
        for (HccrHomeSchoolingKindType value : allHccrHomeSchoolingKindTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrHomeSchoolingKindType();
    }
}
