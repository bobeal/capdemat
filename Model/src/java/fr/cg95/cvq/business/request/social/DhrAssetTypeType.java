package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class DhrAssetTypeType extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final DhrAssetTypeType SHARE = new DhrAssetTypeType("Share");
  
    public static final DhrAssetTypeType GIFT = new DhrAssetTypeType("Gift");
  
    public static final DhrAssetTypeType SALE = new DhrAssetTypeType("Sale");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrAssetTypeType(String value) {
        super(value);
    }

    public DhrAssetTypeType() {}

    public static DhrAssetTypeType[] allDhrAssetTypeTypes = {
        SHARE,
        GIFT,
        SALE
    };

    public static DhrAssetTypeType getDefaultDhrAssetTypeType() {
        return null;
    }

    public static DhrAssetTypeType forString(final String enumAsString) {
        for (DhrAssetTypeType value : allDhrAssetTypeTypes)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultDhrAssetTypeType();
    }
}
