package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class DhrDwellingType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DhrDwellingType DOMICILE = new DhrDwellingType("Domicile");
    public static final DhrDwellingType ETABLISSMENT_P_A = new DhrDwellingType("EtablissmentPA");
    public static final DhrDwellingType ACCUEIL_PARTICULIER_ONEREUX = new DhrDwellingType("AccueilParticulierOnereux");
    public static final DhrDwellingType AUTRE = new DhrDwellingType("Autre");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrDwellingType(String value) {
       super(value);
    }


    public DhrDwellingType() {}



    public static DhrDwellingType getDefaultDhrDwellingType() {
        return null;
    }


    public static DhrDwellingType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDhrDwellingType();

        if (enumAsString.equals(DOMICILE.toString()))
            return DOMICILE;
        else if (enumAsString.equals(ETABLISSMENT_P_A.toString()))
            return ETABLISSMENT_P_A;
        else if (enumAsString.equals(ACCUEIL_PARTICULIER_ONEREUX.toString()))
            return ACCUEIL_PARTICULIER_ONEREUX;
        else if (enumAsString.equals(AUTRE.toString()))
            return AUTRE;

        return getDefaultDhrDwellingType();
    }
}
