

package fr.cg95.cvq.business.request.school;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.oval.constraint.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

import javax.persistence.*;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * Generated class file, do not edit !
 */
@Entity
@Table(name="saintouen_activite_periscolaire_request")
public class SaintouenActivitePeriscolaireRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public SaintouenActivitePeriscolaireRequestData() {
      
        ecoleInscription = fr.cg95.cvq.business.request.school.SaprEcoleInscriptionType.ECOLE_SAINTOUEN;
      
        saprAccueilMatin = Boolean.valueOf(false);
      
        saprAccueilMercrediEtVacances = Boolean.valueOf(false);
      
        saprAccueilSoir = Boolean.valueOf(false);
      
        saprEstAllergique = Boolean.valueOf(false);
      
        saprEstHandicapeInvalidant = Boolean.valueOf(false);
      
        saprEstRestauration = Boolean.valueOf(false);
      
        saprEtudesSurveillees = Boolean.valueOf(false);
      
        saprReglementInterieur = Boolean.valueOf(false);
      
    }

    @Override
    public SaintouenActivitePeriscolaireRequestData clone() {
        SaintouenActivitePeriscolaireRequestData result = new SaintouenActivitePeriscolaireRequestData();
        
          
            
        if (ecoleInscription != null)
            result.setEcoleInscription(ecoleInscription);
        else
            result.setEcoleInscription(fr.cg95.cvq.business.request.school.SaprEcoleInscriptionType.getDefaultSaprEcoleInscriptionType());
      
          
        
          
            
        result.setSaprAccueilMatin(saprAccueilMatin);
      
          
        
          
            
        result.setSaprAccueilMercrediEtVacances(saprAccueilMercrediEtVacances);
      
          
        
          
            
        result.setSaprAccueilSoir(saprAccueilSoir);
      
          
        
          
            
        result.setSaprEstAllergique(saprEstAllergique);
      
          
        
          
            
        result.setSaprEstHandicapeInvalidant(saprEstHandicapeInvalidant);
      
          
        
          
            
        result.setSaprEstRestauration(saprEstRestauration);
      
          
        
          
            
        result.setSaprEtudesSurveillees(saprEtudesSurveillees);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> saprModeReglementList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : saprModeReglement) {
            saprModeReglementList.add(object.clone());
        }
        result.setSaprModeReglement(saprModeReglementList);
      
          
        
          
            
        result.setSaprReglementInterieur(saprReglementInterieur);
      
          
        
        return result;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public final Long getId() {
        return this.id;
    }

  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "ecoleInscription"
      )
    
    private fr.cg95.cvq.business.request.school.SaprEcoleInscriptionType ecoleInscription;

    public void setEcoleInscription(final fr.cg95.cvq.business.request.school.SaprEcoleInscriptionType ecoleInscription) {
        this.ecoleInscription = ecoleInscription;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="ecole_inscription"  )
      
    public fr.cg95.cvq.business.request.school.SaprEcoleInscriptionType getEcoleInscription() {
        return this.ecoleInscription;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "saprAccueilMatin"
      )
    
    private Boolean saprAccueilMatin;

    public void setSaprAccueilMatin(final Boolean saprAccueilMatin) {
        this.saprAccueilMatin = saprAccueilMatin;
    }

 
    @Column(name="sapr_accueil_matin"  )
      
    public Boolean getSaprAccueilMatin() {
        return this.saprAccueilMatin;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "saprAccueilMercrediEtVacances"
      )
    
    private Boolean saprAccueilMercrediEtVacances;

    public void setSaprAccueilMercrediEtVacances(final Boolean saprAccueilMercrediEtVacances) {
        this.saprAccueilMercrediEtVacances = saprAccueilMercrediEtVacances;
    }

 
    @Column(name="sapr_accueil_mercredi_et_vacances"  )
      
    public Boolean getSaprAccueilMercrediEtVacances() {
        return this.saprAccueilMercrediEtVacances;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "saprAccueilSoir"
      )
    
    private Boolean saprAccueilSoir;

    public void setSaprAccueilSoir(final Boolean saprAccueilSoir) {
        this.saprAccueilSoir = saprAccueilSoir;
    }

 
    @Column(name="sapr_accueil_soir"  )
      
    public Boolean getSaprAccueilSoir() {
        return this.saprAccueilSoir;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "saprEstAllergique"
      )
    
    private Boolean saprEstAllergique;

    public void setSaprEstAllergique(final Boolean saprEstAllergique) {
        this.saprEstAllergique = saprEstAllergique;
    }

 
    @Column(name="sapr_est_allergique"  )
      
    public Boolean getSaprEstAllergique() {
        return this.saprEstAllergique;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "saprEstHandicapeInvalidant"
      )
    
    private Boolean saprEstHandicapeInvalidant;

    public void setSaprEstHandicapeInvalidant(final Boolean saprEstHandicapeInvalidant) {
        this.saprEstHandicapeInvalidant = saprEstHandicapeInvalidant;
    }

 
    @Column(name="sapr_est_handicape_invalidant"  )
      
    public Boolean getSaprEstHandicapeInvalidant() {
        return this.saprEstHandicapeInvalidant;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "saprEstRestauration"
      )
    
    private Boolean saprEstRestauration;

    public void setSaprEstRestauration(final Boolean saprEstRestauration) {
        this.saprEstRestauration = saprEstRestauration;
    }

 
    @Column(name="sapr_est_restauration"  )
      
    public Boolean getSaprEstRestauration() {
        return this.saprEstRestauration;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "saprEtudesSurveillees"
      )
    
    private Boolean saprEtudesSurveillees;

    public void setSaprEtudesSurveillees(final Boolean saprEtudesSurveillees) {
        this.saprEtudesSurveillees = saprEtudesSurveillees;
    }

 
    @Column(name="sapr_etudes_surveillees"  )
      
    public Boolean getSaprEtudesSurveillees() {
        return this.saprEtudesSurveillees;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"paiement"},
        message = "saprModeReglement"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"paiement"},
        message = "saprModeReglement"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> saprModeReglement;

    public void setSaprModeReglement(final List<fr.cg95.cvq.business.request.LocalReferentialData> saprModeReglement) {
        this.saprModeReglement = saprModeReglement;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="saintouen_activite_periscolaire_request_sapr_mode_reglement",
            joinColumns=
                @JoinColumn(name="saintouen_activite_periscolaire_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="sapr_mode_reglement_id"))
    @OrderColumn(name="sapr_mode_reglement_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getSaprModeReglement() {
        return this.saprModeReglement;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "saprReglementInterieur"
      )
    
      @AssertTrue(
        
        
        profiles = {"activites"},
        message = "saprReglementInterieur"
      )
    
    private Boolean saprReglementInterieur;

    public void setSaprReglementInterieur(final Boolean saprReglementInterieur) {
        this.saprReglementInterieur = saprReglementInterieur;
    }

 
    @Column(name="sapr_reglement_interieur"  )
      
    public Boolean getSaprReglementInterieur() {
        return this.saprReglementInterieur;
    }
  
}
