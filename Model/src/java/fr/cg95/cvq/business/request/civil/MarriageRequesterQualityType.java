package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.civil.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class MarriageRequesterQualityType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final MarriageRequesterQualityType REQUESTER = new MarriageRequesterQualityType("Requester");
    public static final MarriageRequesterQualityType SPOUSE = new MarriageRequesterQualityType("Spouse");
    public static final MarriageRequesterQualityType PARENT = new MarriageRequesterQualityType("Parent");
    public static final MarriageRequesterQualityType GRAND_PARENT = new MarriageRequesterQualityType("GrandParent");
    public static final MarriageRequesterQualityType CHILD = new MarriageRequesterQualityType("Child");
    public static final MarriageRequesterQualityType LEGAL_REPRESENTANT = new MarriageRequesterQualityType("LegalRepresentant");
    public static final MarriageRequesterQualityType AGENT = new MarriageRequesterQualityType("Agent");
    public static final MarriageRequesterQualityType HEIR_FAMILY = new MarriageRequesterQualityType("HeirFamily");
    public static final MarriageRequesterQualityType HEIR = new MarriageRequesterQualityType("Heir");
    public static final MarriageRequesterQualityType AUTHORIZED = new MarriageRequesterQualityType("Authorized");
    public static final MarriageRequesterQualityType LAWYER_NOTARY = new MarriageRequesterQualityType("LawyerNotary");
    public static final MarriageRequesterQualityType OTHER = new MarriageRequesterQualityType("Other");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private MarriageRequesterQualityType(String value) {
       super(value);
    }


    public MarriageRequesterQualityType() {}



    public static MarriageRequesterQualityType[] allMarriageRequesterQualityTypes = {
        REQUESTER,
        SPOUSE,
        PARENT,
        GRAND_PARENT,
        CHILD,
        LEGAL_REPRESENTANT,
        AGENT,
        HEIR_FAMILY,
        HEIR,
        AUTHORIZED,
        LAWYER_NOTARY,
        OTHER
    };


    public static MarriageRequesterQualityType getDefaultMarriageRequesterQualityType() {
        return null;
    }


    public static MarriageRequesterQualityType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultMarriageRequesterQualityType();

        if (enumAsString.equals(REQUESTER.toString()))
            return REQUESTER;
        else if (enumAsString.equals(SPOUSE.toString()))
            return SPOUSE;
        else if (enumAsString.equals(PARENT.toString()))
            return PARENT;
        else if (enumAsString.equals(GRAND_PARENT.toString()))
            return GRAND_PARENT;
        else if (enumAsString.equals(CHILD.toString()))
            return CHILD;
        else if (enumAsString.equals(LEGAL_REPRESENTANT.toString()))
            return LEGAL_REPRESENTANT;
        else if (enumAsString.equals(AGENT.toString()))
            return AGENT;
        else if (enumAsString.equals(HEIR_FAMILY.toString()))
            return HEIR_FAMILY;
        else if (enumAsString.equals(HEIR.toString()))
            return HEIR;
        else if (enumAsString.equals(AUTHORIZED.toString()))
            return AUTHORIZED;
        else if (enumAsString.equals(LAWYER_NOTARY.toString()))
            return LAWYER_NOTARY;
        else if (enumAsString.equals(OTHER.toString()))
            return OTHER;

        return getDefaultMarriageRequesterQualityType();
    }
}
