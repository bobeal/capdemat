package fr.cg95.cvq.business.request.social;

/**
 * Generated class file, do not edit !
 */
public enum SagrSportPratiqueType {

    AEROMODELISME("Aeromodelisme"),
    AEROSTATION("Aerostation"),
    AIKIDO("Aikido"),
    ATHLETISME("Athletisme"),
    AVIRON("Aviron"),
    BADMINTON("Badminton"),
    BASE_BALL("BaseBall"),
    BASKET_BALL("BasketBall"),
    BILLARD("Billard"),
    BOULES_LYONNAISES("BoulesLyonnaises"),
    BOWLING("Bowling"),
    BOXE_AMERICAINE("BoxeAmericaine"),
    BOXE_ANGLAISE("BoxeAnglaise"),
    BOXE_FRANCAISE("BoxeFrancaise"),
    BOXE_THAILANDAISE("BoxeThailandaise"),
    CANOE_KAYAK("CanoeKayak"),
    COURSE_ORIENTATION("CourseOrientation"),
    CYCLISME("Cyclisme"),
    CYCLO_TOURISME("CycloTourisme"),
    CYCLO_VTT("CycloVtt"),
    DANSE("Danse"),
    ECHECS("Echecs"),
    EQUITATION("Equitation"),
    ESCALADE_ET_MONTAGNE("EscaladeEtMontagne"),
    ESCRIME("Escrime"),
    FOOTBALL("Football"),
    FOOTBALL_AMERICAIN("FootballAmericain"),
    FUTSAL("Futsal"),
    GOLF("Golf"),
    GYM_RYTHM_SPORTIVE("GymRythmSportive"),
    GYM_VOLONTAIRE("GymVolontaire"),
    HALTEROPHILIE("Halterophilie"),
    HAND_BALL("HandBall"),
    HOCKEY_SUR_GLACE("HockeySurGlace"),
    JEU_DE_PAUME("JeuDePaume"),
    JOUTES("Joutes"),
    JUDO("Judo"),
    KARATE("Karate"),
    KICKBOXING("Kickboxing"),
    LUTTE("Lutte"),
    MOTO_CYCLISME("MotoCyclisme"),
    NATATION("Natation"),
    PARACHUTISME("Parachutisme"),
    PATINS_A_ROULETTES("PatinsARoulettes"),
    PECHE_A_LA_MOUCHE("PecheALaMouche"),
    PECHE_AU_COUP("PecheAuCoup"),
    PETANQUE("Petanque"),
    RANDONNEE_PEDESTRE("RandonneePedestre"),
    ROLLER_SKATING_ET_DA("RollerSkatingEtDa"),
    RUGBY("Rugby"),
    SAMBO("Sambo"),
    SKATE_BOARD("SkateBoard"),
    SKI("Ski"),
    SKI_NAUTIQUE("SkiNautique"),
    SPELEOLOGIE("Speleologie"),
    SPORTS_DE_GLACE("SportsDeGlace"),
    SPORTS_HANDICAPES("SportsHandicapes"),
    SPORTS_SOUS_MARINS("SportsSousMarins"),
    SQUASH("Squash"),
    TAEKWONDO_ET_DA("TaekwondoEtDa"),
    TAICHI_CHUAN_QI_GONG("TaichiChuanQiGong"),
    TENNIS("Tennis"),
    TENNIS_DE_TABLE("TennisDeTable"),
    TIR_A_ARC("TirAArc"),
    TIR_AUX_ARMES("TirAuxArmes"),
    TRAMPOLINE("Trampoline"),
    TRIATHLON("Triathlon"),
    TWIRLING_BATON("TwirlingBaton"),
    VIET_VO_DAO_ET_DA("VietVoDaoEtDa"),
    VOILE("Voile"),
    VOL_A_VOILE("VolAVoile"),
    VOL_LIBRE("VolLibre"),
    VOLLEY_BALL("VolleyBall"),
    AUTRE("Autre");


    /**
     * only for backward use SagrSportPratiqueType.values() instead
     * @deprecated only for backward
     */
    @Deprecated 
    public static SagrSportPratiqueType[] allSagrSportPratiqueTypes = SagrSportPratiqueType.values();

    private String legacyLabel;

    private SagrSportPratiqueType(String legacyLabel){
        this.legacyLabel = legacyLabel;
    }

    public String getLegacyLabel() {
        return legacyLabel;
    }

    public static SagrSportPratiqueType getDefaultSagrSportPratiqueType() {
        return null;
    }

    /**
     * @deprecated use valueOf instead. Watchout! you must provid something of SagrSportPratiqueType.something
     * not the value of the name attribut.
     */
    public static SagrSportPratiqueType forString(final String enumAsString) {
        for (SagrSportPratiqueType value : values())
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultSagrSportPratiqueType();
    }
}
