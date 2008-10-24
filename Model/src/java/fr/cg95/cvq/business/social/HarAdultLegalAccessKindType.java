package fr.cg95.cvq.business.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;

/**
 *
 * Generated class file, do not edit!
 */
public final class HarAdultLegalAccessKindType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final HarAdultLegalAccessKindType SAUVEGARDE_JUSTICE = new HarAdultLegalAccessKindType("SauvegardeJustice");
    public static final HarAdultLegalAccessKindType TUTELLE = new HarAdultLegalAccessKindType("Tutelle");
    public static final HarAdultLegalAccessKindType CURATELLE = new HarAdultLegalAccessKindType("Curatelle");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private HarAdultLegalAccessKindType(String value) {
       super(value);
    }


    public HarAdultLegalAccessKindType() {}



    public static HarAdultLegalAccessKindType getDefaultHarAdultLegalAccessKindType() {
        return null;
    }


    public static HarAdultLegalAccessKindType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultHarAdultLegalAccessKindType();

        if (enumAsString.equals(SAUVEGARDE_JUSTICE.toString()))
            return SAUVEGARDE_JUSTICE;
        else if (enumAsString.equals(TUTELLE.toString()))
            return TUTELLE;
        else if (enumAsString.equals(CURATELLE.toString()))
            return CURATELLE;

        return getDefaultHarAdultLegalAccessKindType();
    }
}
