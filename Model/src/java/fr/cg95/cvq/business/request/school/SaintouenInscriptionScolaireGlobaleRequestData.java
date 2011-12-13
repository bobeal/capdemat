

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
@Table(name="saintouen_inscription_scolaire_globale_request")
public class SaintouenInscriptionScolaireGlobaleRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public SaintouenInscriptionScolaireGlobaleRequestData() {
      
        accueilMatin = Boolean.valueOf(false);
      
        accueilMercrediEtVacances = Boolean.valueOf(false);
      
        accueilSoir = Boolean.valueOf(false);
      
        estAllergique = Boolean.valueOf(false);
      
        estHandicapeInvalidant = Boolean.valueOf(false);
      
        estRestauration = Boolean.valueOf(false);
      
        etudesSurveillees = Boolean.valueOf(false);
      
        reglementInterieur = Boolean.valueOf(false);
      
    }

    @Override
    public SaintouenInscriptionScolaireGlobaleRequestData clone() {
        SaintouenInscriptionScolaireGlobaleRequestData result = new SaintouenInscriptionScolaireGlobaleRequestData();
        
          
            
        result.setAccueilMatin(accueilMatin);
      
          
        
          
            
        result.setAccueilMercrediEtVacances(accueilMercrediEtVacances);
      
          
        
          
            
        result.setAccueilSoir(accueilSoir);
      
          
        
          
            
        result.setEstAllergique(estAllergique);
      
          
        
          
            
        result.setEstHandicapeInvalidant(estHandicapeInvalidant);
      
          
        
          
            
        result.setEstRestauration(estRestauration);
      
          
        
          
            
        result.setEtudesSurveillees(etudesSurveillees);
      
          
        
          
            
        result.setIdEcoleSecteur(idEcoleSecteur);
      
          
        
          
            
        result.setLabelEcoleSecteur(labelEcoleSecteur);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> modeReglementList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : modeReglement) {
            modeReglementList.add(object.clone());
        }
        result.setModeReglement(modeReglementList);
      
          
        
          
            
        result.setReglementInterieur(reglementInterieur);
      
          
        
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
        
        
        profiles = {"activites"},
        message = "accueilMatin"
      )
    
    private Boolean accueilMatin;

    public void setAccueilMatin(final Boolean accueilMatin) {
        this.accueilMatin = accueilMatin;
    }

 
    @Column(name="accueil_matin"  )
      
    public Boolean getAccueilMatin() {
        return this.accueilMatin;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "accueilMercrediEtVacances"
      )
    
    private Boolean accueilMercrediEtVacances;

    public void setAccueilMercrediEtVacances(final Boolean accueilMercrediEtVacances) {
        this.accueilMercrediEtVacances = accueilMercrediEtVacances;
    }

 
    @Column(name="accueil_mercredi_et_vacances"  )
      
    public Boolean getAccueilMercrediEtVacances() {
        return this.accueilMercrediEtVacances;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "accueilSoir"
      )
    
    private Boolean accueilSoir;

    public void setAccueilSoir(final Boolean accueilSoir) {
        this.accueilSoir = accueilSoir;
    }

 
    @Column(name="accueil_soir"  )
      
    public Boolean getAccueilSoir() {
        return this.accueilSoir;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "estAllergique"
      )
    
    private Boolean estAllergique;

    public void setEstAllergique(final Boolean estAllergique) {
        this.estAllergique = estAllergique;
    }

 
    @Column(name="est_allergique"  )
      
    public Boolean getEstAllergique() {
        return this.estAllergique;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "estHandicapeInvalidant"
      )
    
    private Boolean estHandicapeInvalidant;

    public void setEstHandicapeInvalidant(final Boolean estHandicapeInvalidant) {
        this.estHandicapeInvalidant = estHandicapeInvalidant;
    }

 
    @Column(name="est_handicape_invalidant"  )
      
    public Boolean getEstHandicapeInvalidant() {
        return this.estHandicapeInvalidant;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "estRestauration"
      )
    
    private Boolean estRestauration;

    public void setEstRestauration(final Boolean estRestauration) {
        this.estRestauration = estRestauration;
    }

 
    @Column(name="est_restauration"  )
      
    public Boolean getEstRestauration() {
        return this.estRestauration;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "etudesSurveillees"
      )
    
    private Boolean etudesSurveillees;

    public void setEtudesSurveillees(final Boolean etudesSurveillees) {
        this.etudesSurveillees = etudesSurveillees;
    }

 
    @Column(name="etudes_surveillees"  )
      
    public Boolean getEtudesSurveillees() {
        return this.etudesSurveillees;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "idEcoleSecteur"
      )
    
      @NotBlank(
        
        
        profiles = {"enfant"},
        message = "idEcoleSecteur"
      )
    
    private String idEcoleSecteur;

    public void setIdEcoleSecteur(final String idEcoleSecteur) {
        this.idEcoleSecteur = idEcoleSecteur;
    }

 
    @Column(name="id_ecole_secteur"  )
      
    public String getIdEcoleSecteur() {
        return this.idEcoleSecteur;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "labelEcoleSecteur"
      )
    
      @NotBlank(
        
        
        profiles = {"enfant"},
        message = "labelEcoleSecteur"
      )
    
    private String labelEcoleSecteur;

    public void setLabelEcoleSecteur(final String labelEcoleSecteur) {
        this.labelEcoleSecteur = labelEcoleSecteur;
    }

 
    @Column(name="label_ecole_secteur"  )
      
    public String getLabelEcoleSecteur() {
        return this.labelEcoleSecteur;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"paiement"},
        message = "modeReglement"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"paiement"},
        message = "modeReglement"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> modeReglement;

    public void setModeReglement(final List<fr.cg95.cvq.business.request.LocalReferentialData> modeReglement) {
        this.modeReglement = modeReglement;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="saintouen_inscription_scolaire_globale_request_mode_reglement",
            joinColumns=
                @JoinColumn(name="saintouen_inscription_scolaire_globale_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="mode_reglement_id"))
    @OrderColumn(name="mode_reglement_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getModeReglement() {
        return this.modeReglement;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "reglementInterieur"
      )
    
      @AssertTrue(
        
        
        profiles = {"activites"},
        message = "reglementInterieur"
      )
    
    private Boolean reglementInterieur;

    public void setReglementInterieur(final Boolean reglementInterieur) {
        this.reglementInterieur = reglementInterieur;
    }

 
    @Column(name="reglement_interieur"  )
      
    public Boolean getReglementInterieur() {
        return this.reglementInterieur;
    }
  
}
