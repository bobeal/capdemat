package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class DhrAssetKindType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final DhrAssetKindType REAL_ESTATE = new DhrAssetKindType("RealEstate");
  
    public static final DhrAssetKindType OTHER = new DhrAssetKindType("Other");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrAssetKindType(String value) {
        super(value);
    }

    public DhrAssetKindType() {}

    public static DhrAssetKindType[] allDhrAssetKindTypes = {
        REAL_ESTATE,
        OTHER
    };

    public static DhrAssetKindType getDefaultDhrAssetKindType() {
        return null;
    }

    public static DhrAssetKindType forString(final String enumAsString) {
        for (DhrAssetKindType value : allDhrAssetKindTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDhrAssetKindType();
    }
}
