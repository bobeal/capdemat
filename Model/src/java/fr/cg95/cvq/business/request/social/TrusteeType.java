package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 *
 * Generated class file, do not edit !
 */
public enum TrusteeType {

    REQUESTER("Requester"),
    OTHER("Other");

    private static final long serialVersionUID = 1L;
    private String name;

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private TrusteeType(String value) {
        this.name = value;
    }

    /**
     * @deprecated only for backward, use values() instead
     */
    public static TrusteeType[] allTrusteeTypes = TrusteeType.values();

    public static TrusteeType getDefaultTrusteeType() {
        return null;
    }

    public static TrusteeType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultTrusteeType();

        if (enumAsString.equals(REQUESTER.toString()))
            return REQUESTER;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultTrusteeType();
    }

    @Override
    public String toString() {
        return name;
    }
}
