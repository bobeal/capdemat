package fr.cg95.cvq.business.request.election;

/**
 * Generated class file, do not edit !
 */
public enum SerrrPrecisionNationaliteType {

    DE("de"),
    AD("ad"),
    AT("at"),
    BE("be"),
    GB("gb"),
    BG("bg"),
    CY("cy"),
    DK("dk"),
    ES("es"),
    EE("ee"),
    FI("fi"),
    GR("gr"),
    HU("hu"),
    IE("ie"),
    IT("it"),
    LV("lv"),
    LT("lt"),
    LU("lu"),
    MT("mt"),
    NL("nl"),
    PL("pl"),
    PT("pt"),
    RO("ro"),
    SI("si"),
    SK("sk"),
    SE("se"),
    CZ("cz");


    /**
     * only for backward use SerrrPrecisionNationaliteType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SerrrPrecisionNationaliteType[] allSerrrPrecisionNationaliteTypes = SerrrPrecisionNationaliteType.values();

    private String legacyLabel;

    private SerrrPrecisionNationaliteType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SerrrPrecisionNationaliteType getDefaultSerrrPrecisionNationaliteType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SerrrPrecisionNationaliteType.something
     * not the value of the name attribut.
     */
    public static SerrrPrecisionNationaliteType forString(final String enumAsString) {
        for (SerrrPrecisionNationaliteType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSerrrPrecisionNationaliteType();
    }
}
