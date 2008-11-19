package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
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
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDhrAssetTypeType();

        if (enumAsString.equals(SHARE.toString()))
            return SHARE;
        else if (enumAsString.equals(GIFT.toString()))
            return GIFT;
        else if (enumAsString.equals(SALE.toString()))
            return SALE;

        return getDefaultDhrAssetTypeType();
    }
}
