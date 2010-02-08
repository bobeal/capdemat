package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class HccrSchoolingKindType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final HccrSchoolingKindType FULL_TIME = new HccrSchoolingKindType("FullTime");
  
    public static final HccrSchoolingKindType PART_TIME = new HccrSchoolingKindType("PartTime");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HccrSchoolingKindType(String value) {
        super(value);
    }

    public HccrSchoolingKindType() {}

    public static HccrSchoolingKindType[] allHccrSchoolingKindTypes = {
        FULL_TIME,
        PART_TIME
    };

    public static HccrSchoolingKindType getDefaultHccrSchoolingKindType() {
        return null;
    }

    public static HccrSchoolingKindType forString(final String enumAsString) {
        for (HccrSchoolingKindType value : allHccrSchoolingKindTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultHccrSchoolingKindType();
    }
}
