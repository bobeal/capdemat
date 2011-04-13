package fr.cg95.cvq.business.users;

/**
 * Enumeration of all French departments.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public enum InseeDepartementCodeType { 


    NONE("None"),
    D_E_P_01("DEP_01"),
    D_E_P_02("DEP_02"),
    D_E_P_03("DEP_03"),
    D_E_P_04("DEP_04"),
    D_E_P_05("DEP_05"),
    D_E_P_06("DEP_06"),
    D_E_P_07("DEP_07"),
    D_E_P_08("DEP_08"),
    D_E_P_09("DEP_09"),
    D_E_P_10("DEP_10"),
    D_E_P_11("DEP_11"),
    D_E_P_12("DEP_12"),
    D_E_P_13("DEP_13"),
    D_E_P_14("DEP_14"),
    D_E_P_15("DEP_15"),
    D_E_P_16("DEP_16"),
    D_E_P_17("DEP_17"),
    D_E_P_18("DEP_18"),
    D_E_P_19("DEP_19"),
    D_E_P_2_A("DEP_2A"),
    D_E_P_2_B("DEP_2B"),
    D_E_P_21("DEP_21"),
    D_E_P_22("DEP_22"),
    D_E_P_23("DEP_23"),
    D_E_P_24("DEP_24"),
    D_E_P_25("DEP_25"),
    D_E_P_26("DEP_26"),
    D_E_P_27("DEP_27"),
    D_E_P_28("DEP_28"),
    D_E_P_29("DEP_29"),
    D_E_P_30("DEP_30"),
    D_E_P_31("DEP_31"),
    D_E_P_32("DEP_32"),
    D_E_P_33("DEP_33"),
    D_E_P_34("DEP_34"),
    D_E_P_35("DEP_35"),
    D_E_P_36("DEP_36"),
    D_E_P_37("DEP_37"),
    D_E_P_38("DEP_38"),
    D_E_P_39("DEP_39"),
    D_E_P_40("DEP_40"),
    D_E_P_41("DEP_41"),
    D_E_P_42("DEP_42"),
    D_E_P_43("DEP_43"),
    D_E_P_44("DEP_44"),
    D_E_P_45("DEP_45"),
    D_E_P_46("DEP_46"),
    D_E_P_47("DEP_47"),
    D_E_P_48("DEP_48"),
    D_E_P_49("DEP_49"),
    D_E_P_50("DEP_50"),
    D_E_P_51("DEP_51"),
    D_E_P_52("DEP_52"),
    D_E_P_53("DEP_53"),
    D_E_P_54("DEP_54"),
    D_E_P_55("DEP_55"),
    D_E_P_56("DEP_56"),
    D_E_P_57("DEP_57"),
    D_E_P_58("DEP_58"),
    D_E_P_59("DEP_59"),
    D_E_P_60("DEP_60"),
    D_E_P_61("DEP_61"),
    D_E_P_62("DEP_62"),
    D_E_P_63("DEP_63"),
    D_E_P_64("DEP_64"),
    D_E_P_65("DEP_65"),
    D_E_P_66("DEP_66"),
    D_E_P_67("DEP_67"),
    D_E_P_68("DEP_68"),
    D_E_P_69("DEP_69"),
    D_E_P_70("DEP_70"),
    D_E_P_71("DEP_71"),
    D_E_P_72("DEP_72"),
    D_E_P_73("DEP_73"),
    D_E_P_74("DEP_74"),
    D_E_P_75("DEP_75"),
    D_E_P_76("DEP_76"),
    D_E_P_77("DEP_77"),
    D_E_P_78("DEP_78"),
    D_E_P_79("DEP_79"),
    D_E_P_80("DEP_80"),
    D_E_P_81("DEP_81"),
    D_E_P_82("DEP_82"),
    D_E_P_83("DEP_83"),
    D_E_P_84("DEP_84"),
    D_E_P_85("DEP_85"),
    D_E_P_86("DEP_86"),
    D_E_P_87("DEP_87"),
    D_E_P_88("DEP_88"),
    D_E_P_89("DEP_89"),
    D_E_P_90("DEP_90"),
    D_E_P_91("DEP_91"),
    D_E_P_92("DEP_92"),
    D_E_P_93("DEP_93"),
    D_E_P_94("DEP_94"),
    D_E_P_95("DEP_95"),
    D_E_P_971("DEP_971"),
    D_E_P_972("DEP_972"),
    D_E_P_973("DEP_973"),
    D_E_P_974("DEP_974");

    private String legacyLabel;

    public String getLegacyLabel() {
        return legacyLabel;
    }

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private InseeDepartementCodeType(String legacyLabel) {
        this.legacyLabel = legacyLabel;
    }

    public static InseeDepartementCodeType getDefaultInseeDepartementCodeType() {
        return NONE;
    }


    public static InseeDepartementCodeType forString(final String enumAsString) {
        if (enumAsString == null || enumAsString.equals(""))
            return getDefaultInseeDepartementCodeType();

        if (enumAsString.equals(NONE.toString()))
            return NONE;
        else if (enumAsString.equals(D_E_P_01.toString()))
            return D_E_P_01;
        else if (enumAsString.equals(D_E_P_02.toString()))
            return D_E_P_02;
        else if (enumAsString.equals(D_E_P_03.toString()))
            return D_E_P_03;
        else if (enumAsString.equals(D_E_P_04.toString()))
            return D_E_P_04;
        else if (enumAsString.equals(D_E_P_05.toString()))
            return D_E_P_05;
        else if (enumAsString.equals(D_E_P_06.toString()))
            return D_E_P_06;
        else if (enumAsString.equals(D_E_P_07.toString()))
            return D_E_P_07;
        else if (enumAsString.equals(D_E_P_08.toString()))
            return D_E_P_08;
        else if (enumAsString.equals(D_E_P_09.toString()))
            return D_E_P_09;
        else if (enumAsString.equals(D_E_P_10.toString()))
            return D_E_P_10;
        else if (enumAsString.equals(D_E_P_11.toString()))
            return D_E_P_11;
        else if (enumAsString.equals(D_E_P_12.toString()))
            return D_E_P_12;
        else if (enumAsString.equals(D_E_P_13.toString()))
            return D_E_P_13;
        else if (enumAsString.equals(D_E_P_14.toString()))
            return D_E_P_14;
        else if (enumAsString.equals(D_E_P_15.toString()))
            return D_E_P_15;
        else if (enumAsString.equals(D_E_P_16.toString()))
            return D_E_P_16;
        else if (enumAsString.equals(D_E_P_17.toString()))
            return D_E_P_17;
        else if (enumAsString.equals(D_E_P_18.toString()))
            return D_E_P_18;
        else if (enumAsString.equals(D_E_P_19.toString()))
            return D_E_P_19;
        else if (enumAsString.equals(D_E_P_2_A.toString()))
            return D_E_P_2_A;
        else if (enumAsString.equals(D_E_P_2_B.toString()))
            return D_E_P_2_B;
        else if (enumAsString.equals(D_E_P_21.toString()))
            return D_E_P_21;
        else if (enumAsString.equals(D_E_P_22.toString()))
            return D_E_P_22;
        else if (enumAsString.equals(D_E_P_23.toString()))
            return D_E_P_23;
        else if (enumAsString.equals(D_E_P_24.toString()))
            return D_E_P_24;
        else if (enumAsString.equals(D_E_P_25.toString()))
            return D_E_P_25;
        else if (enumAsString.equals(D_E_P_26.toString()))
            return D_E_P_26;
        else if (enumAsString.equals(D_E_P_27.toString()))
            return D_E_P_27;
        else if (enumAsString.equals(D_E_P_28.toString()))
            return D_E_P_28;
        else if (enumAsString.equals(D_E_P_29.toString()))
            return D_E_P_29;
        else if (enumAsString.equals(D_E_P_30.toString()))
            return D_E_P_30;
        else if (enumAsString.equals(D_E_P_31.toString()))
            return D_E_P_31;
        else if (enumAsString.equals(D_E_P_32.toString()))
            return D_E_P_32;
        else if (enumAsString.equals(D_E_P_33.toString()))
            return D_E_P_33;
        else if (enumAsString.equals(D_E_P_34.toString()))
            return D_E_P_34;
        else if (enumAsString.equals(D_E_P_35.toString()))
            return D_E_P_35;
        else if (enumAsString.equals(D_E_P_36.toString()))
            return D_E_P_36;
        else if (enumAsString.equals(D_E_P_37.toString()))
            return D_E_P_37;
        else if (enumAsString.equals(D_E_P_38.toString()))
            return D_E_P_38;
        else if (enumAsString.equals(D_E_P_39.toString()))
            return D_E_P_39;
        else if (enumAsString.equals(D_E_P_40.toString()))
            return D_E_P_40;
        else if (enumAsString.equals(D_E_P_41.toString()))
            return D_E_P_41;
        else if (enumAsString.equals(D_E_P_42.toString()))
            return D_E_P_42;
        else if (enumAsString.equals(D_E_P_43.toString()))
            return D_E_P_43;
        else if (enumAsString.equals(D_E_P_44.toString()))
            return D_E_P_44;
        else if (enumAsString.equals(D_E_P_45.toString()))
            return D_E_P_45;
        else if (enumAsString.equals(D_E_P_46.toString()))
            return D_E_P_46;
        else if (enumAsString.equals(D_E_P_47.toString()))
            return D_E_P_47;
        else if (enumAsString.equals(D_E_P_48.toString()))
            return D_E_P_48;
        else if (enumAsString.equals(D_E_P_49.toString()))
            return D_E_P_49;
        else if (enumAsString.equals(D_E_P_50.toString()))
            return D_E_P_50;
        else if (enumAsString.equals(D_E_P_51.toString()))
            return D_E_P_51;
        else if (enumAsString.equals(D_E_P_52.toString()))
            return D_E_P_52;
        else if (enumAsString.equals(D_E_P_53.toString()))
            return D_E_P_53;
        else if (enumAsString.equals(D_E_P_54.toString()))
            return D_E_P_54;
        else if (enumAsString.equals(D_E_P_55.toString()))
            return D_E_P_55;
        else if (enumAsString.equals(D_E_P_56.toString()))
            return D_E_P_56;
        else if (enumAsString.equals(D_E_P_57.toString()))
            return D_E_P_57;
        else if (enumAsString.equals(D_E_P_58.toString()))
            return D_E_P_58;
        else if (enumAsString.equals(D_E_P_59.toString()))
            return D_E_P_59;
        else if (enumAsString.equals(D_E_P_60.toString()))
            return D_E_P_60;
        else if (enumAsString.equals(D_E_P_61.toString()))
            return D_E_P_61;
        else if (enumAsString.equals(D_E_P_62.toString()))
            return D_E_P_62;
        else if (enumAsString.equals(D_E_P_63.toString()))
            return D_E_P_63;
        else if (enumAsString.equals(D_E_P_64.toString()))
            return D_E_P_64;
        else if (enumAsString.equals(D_E_P_65.toString()))
            return D_E_P_65;
        else if (enumAsString.equals(D_E_P_66.toString()))
            return D_E_P_66;
        else if (enumAsString.equals(D_E_P_67.toString()))
            return D_E_P_67;
        else if (enumAsString.equals(D_E_P_68.toString()))
            return D_E_P_68;
        else if (enumAsString.equals(D_E_P_69.toString()))
            return D_E_P_69;
        else if (enumAsString.equals(D_E_P_70.toString()))
            return D_E_P_70;
        else if (enumAsString.equals(D_E_P_71.toString()))
            return D_E_P_71;
        else if (enumAsString.equals(D_E_P_72.toString()))
            return D_E_P_72;
        else if (enumAsString.equals(D_E_P_73.toString()))
            return D_E_P_73;
        else if (enumAsString.equals(D_E_P_74.toString()))
            return D_E_P_74;
        else if (enumAsString.equals(D_E_P_75.toString()))
            return D_E_P_75;
        else if (enumAsString.equals(D_E_P_76.toString()))
            return D_E_P_76;
        else if (enumAsString.equals(D_E_P_77.toString()))
            return D_E_P_77;
        else if (enumAsString.equals(D_E_P_78.toString()))
            return D_E_P_78;
        else if (enumAsString.equals(D_E_P_79.toString()))
            return D_E_P_79;
        else if (enumAsString.equals(D_E_P_80.toString()))
            return D_E_P_80;
        else if (enumAsString.equals(D_E_P_81.toString()))
            return D_E_P_81;
        else if (enumAsString.equals(D_E_P_82.toString()))
            return D_E_P_82;
        else if (enumAsString.equals(D_E_P_83.toString()))
            return D_E_P_83;
        else if (enumAsString.equals(D_E_P_84.toString()))
            return D_E_P_84;
        else if (enumAsString.equals(D_E_P_85.toString()))
            return D_E_P_85;
        else if (enumAsString.equals(D_E_P_86.toString()))
            return D_E_P_86;
        else if (enumAsString.equals(D_E_P_87.toString()))
            return D_E_P_87;
        else if (enumAsString.equals(D_E_P_88.toString()))
            return D_E_P_88;
        else if (enumAsString.equals(D_E_P_89.toString()))
            return D_E_P_89;
        else if (enumAsString.equals(D_E_P_90.toString()))
            return D_E_P_90;
        else if (enumAsString.equals(D_E_P_91.toString()))
            return D_E_P_91;
        else if (enumAsString.equals(D_E_P_92.toString()))
            return D_E_P_92;
        else if (enumAsString.equals(D_E_P_93.toString()))
            return D_E_P_93;
        else if (enumAsString.equals(D_E_P_94.toString()))
            return D_E_P_94;
        else if (enumAsString.equals(D_E_P_95.toString()))
            return D_E_P_95;
        else if (enumAsString.equals(D_E_P_971.toString()))
            return D_E_P_971;
        else if (enumAsString.equals(D_E_P_972.toString()))
            return D_E_P_972;
        else if (enumAsString.equals(D_E_P_973.toString()))
            return D_E_P_973;
        else if (enumAsString.equals(D_E_P_974.toString()))
            return D_E_P_974;

        return getDefaultInseeDepartementCodeType();
    }

    @Override
    public String toString() {
        return legacyLabel;
    }
}
