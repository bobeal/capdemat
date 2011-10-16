package fr.cg95.cvq.business.request.urbanism;

/**
 * Generated class file, do not edit !
 */
public enum LcrDetailDescriptionType {

    SCAFFOLDING("scaffolding"),
    SKIP("skip"),
    NACELLE("nacelle"),
    MATERIALSTORAGE("materialstorage"),
    SITEHUT("sitehut"),
    PALISADES("palisades"),
    OTHER("other");


    /**
     * only for backward use LcrDetailDescriptionType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static LcrDetailDescriptionType[] allLcrDetailDescriptionTypes = LcrDetailDescriptionType.values();

    private String legacyLabel;

    private LcrDetailDescriptionType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static LcrDetailDescriptionType getDefaultLcrDetailDescriptionType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of LcrDetailDescriptionType.something
     * not the value of the name attribut.
     */
    public static LcrDetailDescriptionType forString(final String enumAsString) {
        for (LcrDetailDescriptionType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultLcrDetailDescriptionType();
    }
}
