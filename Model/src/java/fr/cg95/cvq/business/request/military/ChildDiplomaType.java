package fr.cg95.cvq.business.request.military;

/**
 * Generated class file, do not edit !
 */
public enum ChildDiplomaType {

    B_A_C("BAC"),
    B_E_P("BEP"),
    B_E_P_C("BEPC"),
    BREVET("Brevet"),
    C_F_G("CFG"),
    C_A_P("CAP"),
    D_A_E_U("DAEU"),
    D_E_A("DEA"),
    D_E_U_G("DEUG"),
    LICENCE("Licence"),
    MAITRISE("Maitrise"),
    UNKNOWN("Unknown");


    /**
     * only for backward use ChildDiplomaType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static ChildDiplomaType[] allChildDiplomaTypes = ChildDiplomaType.values();

    private String legacyLabel;

    private ChildDiplomaType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static ChildDiplomaType getDefaultChildDiplomaType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of ChildDiplomaType.something
     * not the value of the name attribut.
     */
    public static ChildDiplomaType forString(final String enumAsString) {
        for (ChildDiplomaType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultChildDiplomaType();
    }
}
