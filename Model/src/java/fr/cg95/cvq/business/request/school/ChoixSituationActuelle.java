package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Generated class file, do not edit !
 */
public final class ChoixSituationActuelle extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;
  
    public static final ChoixSituationActuelle PLEIN = new ChoixSituationActuelle("Plein");
  
    public static final ChoixSituationActuelle PARTIEL = new ChoixSituationActuelle("Partiel");
  
    public static final ChoixSituationActuelle INTERIM = new ChoixSituationActuelle("Interim");
  
    public static final ChoixSituationActuelle ETUDIANT = new ChoixSituationActuelle("Etudiant");
  
    public static final ChoixSituationActuelle STAGE = new ChoixSituationActuelle("Stage");
  
    public static final ChoixSituationActuelle RECHERCHE = new ChoixSituationActuelle("Recherche");
  
    public static final ChoixSituationActuelle PARENT = new ChoixSituationActuelle("Parent");
  
    public static final ChoixSituationActuelle LIBRE = new ChoixSituationActuelle("Libre");
  
    public static final ChoixSituationActuelle CONGE = new ChoixSituationActuelle("Conge");
  
    public static final ChoixSituationActuelle RETRAITE = new ChoixSituationActuelle("Retraite");
  
    public static final ChoixSituationActuelle AUTRE = new ChoixSituationActuelle("Autre");
  

    /**
     * Prevent instantiation and subclassing with a private constructor.
     */
    private ChoixSituationActuelle(String value) {
        super(value);
    }

    public ChoixSituationActuelle() {}

    public static ChoixSituationActuelle[] allChoixSituationActuelles = {
        PLEIN,
        PARTIEL,
        INTERIM,
        ETUDIANT,
        STAGE,
        RECHERCHE,
        PARENT,
        LIBRE,
        CONGE,
        RETRAITE,
        AUTRE
    };

    public static ChoixSituationActuelle getDefaultChoixSituationActuelle() {
        return null;
    }

    public static ChoixSituationActuelle forString(final String enumAsString) {
        for (ChoixSituationActuelle value : allChoixSituationActuelles)
            if (value.toString().equals(enumAsString))
                return value;
        return getDefaultChoixSituationActuelle();
    }
}
