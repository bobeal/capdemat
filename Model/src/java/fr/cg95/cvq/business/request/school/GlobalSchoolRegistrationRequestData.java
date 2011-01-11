
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

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="global_school_registration_request"
 *  lazy="false"
 */
public class GlobalSchoolRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public GlobalSchoolRegistrationRequestData() {
      
        acceptationReglementInterieur = Boolean.valueOf(false);
      
        estDerogation = Boolean.valueOf(false);
      
        estPeriscolaire = Boolean.valueOf(false);
      
        estRestauration = Boolean.valueOf(false);
      
    }

    @Override
    public GlobalSchoolRegistrationRequestData clone() {
        GlobalSchoolRegistrationRequestData result = new GlobalSchoolRegistrationRequestData();
        
          
            
        result.setAcceptationReglementInterieur(acceptationReglementInterieur);
      
          
        
          
            
        result.setEstDerogation(estDerogation);
      
          
        
          
            
        result.setEstPeriscolaire(estPeriscolaire);
      
          
        
          
            
        result.setEstRestauration(estRestauration);
      
          
        
          
            
        result.setIdEcoleDerog(idEcoleDerog);
      
          
        
          
            
        result.setIdEcoleSecteur(idEcoleSecteur);
      
          
        
          
            
        result.setInformationsComplementairesDerogation(informationsComplementairesDerogation);
      
          
        
          
            
        result.setLabelEcoleDerog(labelEcoleDerog);
      
          
        
          
            
        result.setLabelEcoleSecteur(labelEcoleSecteur);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogationEcoleList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : motifsDerogationEcole) {
            motifsDerogationEcoleList.add(object.clone());
        }
        result.setMotifsDerogationEcole(motifsDerogationEcoleList);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> regimeAlimentaireList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : regimeAlimentaire) {
            regimeAlimentaireList.add(object.clone());
        }
        result.setRegimeAlimentaire(regimeAlimentaireList);
      
          
        
        return result;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
    }

  
    
      @NotNull(
        
        
        profiles = {"reglements"},
        message = "acceptationReglementInterieur"
      )
    
    private Boolean acceptationReglementInterieur;

    public final void setAcceptationReglementInterieur(final Boolean acceptationReglementInterieur) {
        this.acceptationReglementInterieur = acceptationReglementInterieur;
    }

    /**
 
        * @hibernate.property
        *  column="acceptation_reglement_interieur"
        
      
    */
    public final Boolean getAcceptationReglementInterieur() {
        return this.acceptationReglementInterieur;
    }
  
    
      @NotNull(
        
        
        profiles = {"enfant"},
        message = "estDerogation"
      )
    
    private Boolean estDerogation;

    public final void setEstDerogation(final Boolean estDerogation) {
        this.estDerogation = estDerogation;
    }

    /**
 
        * @hibernate.property
        *  column="est_derogation"
        
      
    */
    public final Boolean getEstDerogation() {
        return this.estDerogation;
    }
  
    
      @NotNull(
        
        
        profiles = {"periscolaire"},
        message = "estPeriscolaire"
      )
    
    private Boolean estPeriscolaire;

    public final void setEstPeriscolaire(final Boolean estPeriscolaire) {
        this.estPeriscolaire = estPeriscolaire;
    }

    /**
 
        * @hibernate.property
        *  column="est_periscolaire"
        
      
    */
    public final Boolean getEstPeriscolaire() {
        return this.estPeriscolaire;
    }
  
    
      @NotNull(
        
        
        profiles = {"restauration"},
        message = "estRestauration"
      )
    
    private Boolean estRestauration;

    public final void setEstRestauration(final Boolean estRestauration) {
        this.estRestauration = estRestauration;
    }

    /**
 
        * @hibernate.property
        *  column="est_restauration"
        
      
    */
    public final Boolean getEstRestauration() {
        return this.estRestauration;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "idEcoleDerog"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "idEcoleDerog"
      )
    
    private String idEcoleDerog;

    public final void setIdEcoleDerog(final String idEcoleDerog) {
        this.idEcoleDerog = idEcoleDerog;
    }

    /**
 
        * @hibernate.property
        *  column="id_ecole_derog"
        
      
    */
    public final String getIdEcoleDerog() {
        return this.idEcoleDerog;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= !_this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "idEcoleSecteur"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= !_this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "idEcoleSecteur"
      )
    
    private String idEcoleSecteur;

    public final void setIdEcoleSecteur(final String idEcoleSecteur) {
        this.idEcoleSecteur = idEcoleSecteur;
    }

    /**
 
        * @hibernate.property
        *  column="id_ecole_secteur"
        
      
    */
    public final String getIdEcoleSecteur() {
        return this.idEcoleSecteur;
    }
  
    
      @MaxLength(
        
          value = 1024,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "informationsComplementairesDerogation"
      )
    
      @MatchPattern(
        
          pattern = "^.{0,1024}$",
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "informationsComplementairesDerogation"
      )
    
    private String informationsComplementairesDerogation;

    public final void setInformationsComplementairesDerogation(final String informationsComplementairesDerogation) {
        this.informationsComplementairesDerogation = informationsComplementairesDerogation;
    }

    /**
 
        * @hibernate.property
        *  column="informations_complementaires_derogation"
        *  length="1024"
      
    */
    public final String getInformationsComplementairesDerogation() {
        return this.informationsComplementairesDerogation;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "labelEcoleDerog"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "labelEcoleDerog"
      )
    
    private String labelEcoleDerog;

    public final void setLabelEcoleDerog(final String labelEcoleDerog) {
        this.labelEcoleDerog = labelEcoleDerog;
    }

    /**
 
        * @hibernate.property
        *  column="label_ecole_derog"
        
      
    */
    public final String getLabelEcoleDerog() {
        return this.labelEcoleDerog;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= !_this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "labelEcoleSecteur"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= !_this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            "return active",
        
        profiles = {"enfant"},
        message = "labelEcoleSecteur"
      )
    
    private String labelEcoleSecteur;

    public final void setLabelEcoleSecteur(final String labelEcoleSecteur) {
        this.labelEcoleSecteur = labelEcoleSecteur;
    }

    /**
 
        * @hibernate.property
        *  column="label_ecole_secteur"
        
      
    */
    public final String getLabelEcoleSecteur() {
        return this.labelEcoleSecteur;
    }
  
    
      @LocalReferential(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "motifsDerogationEcole"
      )
    
      @MinSize(
        
          value = 1,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estDerogation'].test(_this.estDerogation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"enfant"},
        message = "motifsDerogationEcole"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogationEcole;

    public final void setMotifsDerogationEcole(final List<fr.cg95.cvq.business.request.LocalReferentialData> motifsDerogationEcole) {
        this.motifsDerogationEcole = motifsDerogationEcole;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="global_school_registration_request_motifs_derogation_ecole"
        * @hibernate.key
        *  column="global_school_registration_request_id"
        * @hibernate.list-index
        *  column="motifs_derogation_ecole_index"
        * @hibernate.many-to-many
        *  column="motifs_derogation_ecole_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getMotifsDerogationEcole() {
        return this.motifsDerogationEcole;
    }
  
    
      @LocalReferential(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estRestauration'].test(_this.estRestauration.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"restauration"},
        message = "regimeAlimentaire"
      )
    
      @MinSize(
        
          value = 1,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['estRestauration'].test(_this.estRestauration.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"restauration"},
        message = "regimeAlimentaire"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> regimeAlimentaire;

    public final void setRegimeAlimentaire(final List<fr.cg95.cvq.business.request.LocalReferentialData> regimeAlimentaire) {
        this.regimeAlimentaire = regimeAlimentaire;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="global_school_registration_request_regime_alimentaire"
        * @hibernate.key
        *  column="global_school_registration_request_id"
        * @hibernate.list-index
        *  column="regime_alimentaire_index"
        * @hibernate.many-to-many
        *  column="regime_alimentaire_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getRegimeAlimentaire() {
        return this.regimeAlimentaire;
    }
  
}
