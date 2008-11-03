package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class DhrTutorType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final DhrTutorType SAUVEGARDE_JUSTICE = new DhrTutorType("SauvegardeJustice");
    public static final DhrTutorType TUTELLE = new DhrTutorType("Tutelle");
    public static final DhrTutorType CURATELLE = new DhrTutorType("Curatelle");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private DhrTutorType(String value) {
       super(value);
    }


    public DhrTutorType() {}



    public static DhrTutorType getDefaultDhrTutorType() {
        return null;
    }


    public static DhrTutorType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultDhrTutorType();

        if (enumAsString.equals(SAUVEGARDE_JUSTICE.toString()))
            return SAUVEGARDE_JUSTICE;
        else if (enumAsString.equals(TUTELLE.toString()))
            return TUTELLE;
        else if (enumAsString.equals(CURATELLE.toString()))
            return CURATELLE;

        return getDefaultDhrTutorType();
    }
}
