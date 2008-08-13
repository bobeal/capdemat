package fr.cg95.cvq.business.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class DhrDonationAssetType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DhrDonationAssetType IMMOBILIER = new DhrDonationAssetType("Immobilier");
    public static final DhrDonationAssetType AUTRE = new DhrDonationAssetType("Autre");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrDonationAssetType(String value) {
       super(value);
    }


    public DhrDonationAssetType() {}



    public static DhrDonationAssetType getDefaultDhrDonationAssetType() {
        return null;
    }


    public static DhrDonationAssetType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDhrDonationAssetType();

        if (enumAsString.equals(IMMOBILIER.toString()))
            return IMMOBILIER;
        else if (enumAsString.equals(AUTRE.toString()))
            return AUTRE;

        return getDefaultDhrDonationAssetType();
    }
}
