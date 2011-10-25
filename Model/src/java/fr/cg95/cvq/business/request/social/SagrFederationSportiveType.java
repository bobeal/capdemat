package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum SagrFederationSportiveType {

    AEROMODELISME("Aeromodelisme"),
    AEROSTATION("Aerostation"),
    ATHLETISME("Athletisme"),
    BADMINTON("Badminton"),
    BALLON_AU_POING("BallonAuPoing"),
    BASE_BALL("BaseBall"),
    BASKET_BALL("BasketBall"),
    BILLARD("Billard"),
    BOWLING("Bowling"),
    BOXE_BOXE_ANGLAISE("BoxeBoxeAnglaise"),
    CANOE_KAYAK("CanoeKayak"),
    CHAR_A_VOILE("CharAVoile"),
    COURSE_D_ORIENTATION("CourseDOrientation"),
    CYCLISME("Cyclisme"),
    EDUCATION_PHYSIQUE_ET_GYMNASTIQUE_VOLONTAIRE("EducationPhysiqueEtGymnastiqueVolontaire"),
    EQUITATION("Equitation"),
    ESCRIME("Escrime"),
    ETUDES_ET_SPORTS_SOUS_MARINS("EtudesEtSportsSousMarins"),
    FOOTBALL("Football"),
    FOOTBALL_AMERICAIN("FootballAmericain"),
    GIRAVIATION("Giraviation"),
    GOLF("Golf"),
    GYMNASTIQUE("Gymnastique"),
    HALTEROPHILIE("Halterophilie"),
    HAND_BALL("HandBall"),
    HANDISPORT("Handisport"),
    HOCKEY("Hockey"),
    JEU_DE_BALLE_AU_TAMBOURIN("JeuDeBalleAuTambourin"),
    JUDO("Judo"),
    KARATE("Karate"),
    LONGUE_PAUME("LonguePaume"),
    LUTTE("Lutte"),
    MOTO_CYCLISME("MotoCyclisme"),
    MOTONAUTIQUE("Motonautique"),
    MULTISPORTS_OMNISPORTS("MultisportsOmnisports"),
    NATATION("Natation"),
    NATIONALE_AERONAUTIQUE("NationaleAeronautique"),
    PARACHUTISME("Parachutisme"),
    PECHE_A_LA_MOUCHE("PecheALaMouche"),
    PECHE_EN_EAU_DOUCE("PecheEnEauDouce"),
    PECHE_EN_MER("PecheEnMer"),
    PELOTE_BASQUE("PeloteBasque"),
    PETANQUE("Petanque"),
    PLANNEUR_ULTRA_LEGER_MOTORISE("PlanneurUltraLegerMotorise"),
    RANDONNEE_PEDESTRE("RandonneePedestre"),
    ROLLER_SKATING("RollerSkating"),
    RUGBY("Rugby"),
    RUGBY_A_XIII("RugbyAXiii"),
    SAMBO("Sambo"),
    SAUVETAGE_ET_SECOURISME("SauvetageEtSecourisme"),
    SKI_NAUTIQUE("SkiNautique"),
    SOCIETES_D_AVIRON("SocietesDAviron"),
    SPELEOLOGIE("Speleologie"),
    SPORTS_ADAPTES("SportsAdaptes"),
    SPORTS_AUTOMOBILES("SportsAutomobiles"),
    SPORTS_BOULES("SportsBoules"),
    SPORTS_DE_GLACE("SportsDeGlace"),
    SPORTS_DE_QUILLE("SportsDeQuille"),
    SPORTS_EN_MILIEU_RURAL("SportsEnMilieuRural"),
    SQUASH("Squash"),
    SURF_ET_SKATE("SurfEtSkate"),
    TENNIS("Tennis"),
    TENNIS_DE_TABLE("TennisDeTable"),
    TIR("Tir"),
    TIR_A_L_ARC("TirALArc"),
    TRAMPOLINE("Trampoline"),
    TRIATHLON("Triathlon"),
    TWIRLING_BATON("TwirlingBaton"),
    VOILE("Voile"),
    VOL_A_VOILE("VolAVoile"),
    VOL_LIBRE("VolLibre"),
    VOLLEY_BALL("VolleyBall"),
    AUTRE("Autre");


    /**
     * only for backward use SagrFederationSportiveType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SagrFederationSportiveType[] allSagrFederationSportiveTypes = SagrFederationSportiveType.values();

    private String legacyLabel;

    private SagrFederationSportiveType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SagrFederationSportiveType getDefaultSagrFederationSportiveType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SagrFederationSportiveType.something
     * not the value of the name attribut.
     */
    public static SagrFederationSportiveType forString(final String enumAsString) {
        for (SagrFederationSportiveType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSagrFederationSportiveType();
    }
}
