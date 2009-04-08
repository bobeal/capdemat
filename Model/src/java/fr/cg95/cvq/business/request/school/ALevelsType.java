package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.school.*;

/**
 *
 * Generated class file, do not edit !
 */
public final class ALevelsType extends PersistentStringEnum { 

    private static final long serialVersionUID = 1L;

    public static final ALevelsType ES = new ALevelsType("es");
    public static final ALevelsType L = new ALevelsType("l");
    public static final ALevelsType S = new ALevelsType("s");
    public static final ALevelsType STG = new ALevelsType("stg");
    public static final ALevelsType STI = new ALevelsType("sti");
    public static final ALevelsType STL = new ALevelsType("stl");
    public static final ALevelsType ST2S = new ALevelsType("st2s");
    public static final ALevelsType STAV = new ALevelsType("stav");
    public static final ALevelsType TMD = new ALevelsType("tmd");
    public static final ALevelsType H = new ALevelsType("h");
    public static final ALevelsType P = new ALevelsType("p");


    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ALevelsType(String value) {
       super(value);
    }


    public ALevelsType() {}



    public static ALevelsType[] allALevelsTypes = {
        ES,
        L,
        S,
        STG,
        STI,
        STL,
        ST2S,
        STAV,
        TMD,
        H,
        P
    };


    public static ALevelsType getDefaultALevelsType() {
        return null;
    }


    public static ALevelsType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultALevelsType();

        if (enumAsString.equals(ES.toString()))
            return ES;
        else if (enumAsString.equals(L.toString()))
            return L;
        else if (enumAsString.equals(S.toString()))
            return S;
        else if (enumAsString.equals(STG.toString()))
            return STG;
        else if (enumAsString.equals(STI.toString()))
            return STI;
        else if (enumAsString.equals(STL.toString()))
            return STL;
        else if (enumAsString.equals(ST2S.toString()))
            return ST2S;
        else if (enumAsString.equals(STAV.toString()))
            return STAV;
        else if (enumAsString.equals(TMD.toString()))
            return TMD;
        else if (enumAsString.equals(H.toString()))
            return H;
        else if (enumAsString.equals(P.toString()))
            return P;

        return getDefaultALevelsType();
    }
}
